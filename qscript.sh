#!/bin/bash

# specify the Q run in
#$ -q rxn

# the qstat job name
#$ -N  pulsemed

#$ -pe openmp 50

# use the real bash shell
#$ -S /bin/bash

# execute the job out of the current dir and direct the error
# (.e) and output (.o) to the same directory ...
#$ -cwd

# ... Except, in this case, merge the output (.o) and error (.e) into one file
# If you're submitting LOTS of jobs, this halves the filecount and also allows
# you to see what error came at what point in the job.  Recommended unless there's
# good reason NOT to use it.
#$ -j y

#!! NB: that the .e and .o files noted above are the STDERR and STDOUT, not necessarily
#!! the programmatic output that you might be expecting.  That output may well be sent to
#!! other files, depending on how the app was written.

# You may use the following email notifications ONLY IF you're NOT using array jobs.
# If you're using array jobs !!ABSOLUTELY DO NOT!! USE email notification!!

# mail me (hmangala@uci.edu)
# when the job (b)egins, (e)nds, (a)borts,

#!! Now note that the commands are bash commands - no more hiding them behind '#$'

# set a temporary output dir on the LOCAL /scratch filesystem (so data doesn't cross the network)
# note - no spaces around the '='
# the diff between TMP and TMPRUN is that TMP is where any TEMPORARY files are written and
# TMPRUN is where the output files are left (which then have to be copied back to 'safe' storage.)
TMP=/fast-scratch/chubk/adiabatic_low
# We'll name the job subdir the same as the jobname

# set an input directory (where your input data is)
INDIR=/dfs1/elread/rxn-share/chubk/schultz_nsffs

# and final results dir in one place (where your output will stay long-term)jj
FINALDIR=/dfs1/elread/rxn-share/chubk_work/nsffs_work/schultz/adiabatic_low/trials200



# this is where you keep your MD5 checksums locally, altho they'll need to be copied
# elsewhere to be safe (see below)
#MD5SUMDIR=${HOME}/md5sums/guppy/r03-20-2013/md5sums

# make output dirs in the local /scratch and in data filesystem
# I assume that the INDIR already exists with the data in it.
#mkdir -p $TMPRUN $FINALDIR $MD5SUMDIR
mkdir $TMP
cp *.jar $TMP
cp *.class $TMP
cp *.py $TMP
cp *.sh $TMP
cp *.xml $TMP

# load the required module
#module load guppy/2.3.44

# and execute this command.  Note: this is an imaginary command; your app will probably
# have different names for these directories or you may have to specify them in a dotfile.
#guppy --input=${INDIR}/input_file --outdir=${TMPRUN}  --scratchdir=${TMP} --topo=flat --tree --color=off --density=sparse

# get a datestamp
#DATESTAMP=`date|tr /\ / /_/`

# generate md5 checksums of all output data to be able to
# check for corruption if anything happens to the filesystem, god forbid.
#MD5FILE=${MD5SUMDIR}/${JOB_NAME}.md5
#md5deep -r $TMPRUN > ${MD5FILE}


# copy the md5sums to the output dir to include it in the archive
#cp ${MD5FILE} ${TMPRUN}

# mail the md5sums to yourself for safekeeping
#cat ${MD5FILE} | mail -s "${MD5FILE} from HPC"" hmangala@uci.edu

cd $TMP

module load java

java -cp libsbmlj.jar:colt.jar:concurrent.jar:jdom.jar:fern.jar simrunner


# after it finishes, tar/gzip up all the data

# and copy the tarball to its final resting place
#mv ${TARBALL} ${FINALDIR}
mv map.txt ${FINALDIR}
mv smap.txt ${FINALDIR}
mv TrajectoryThread.class ${FINALDIR}
mv qscript.sh ${FINALDIR}
mv simrunner.java ${FINALDIR}
cd ${FINALDIR}
awk '{print $1,$2,$4}' map.txt > map1.txt
# and THIS IS IMPORTANT!! Clean up behind you.
rm -rf $TMP
