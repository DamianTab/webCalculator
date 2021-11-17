#!/bin/bash
JAVA_DIRECTORY="/home/vagrant/java"
VAGRANT_LIBS="/home/vagrant/libs"
JAVA_ARCHIVE="jdk-11.0.12_linux-x64_bin.tar.gz"

mkdir $JAVA_DIRECTORY
cp $VAGRANT_LIBS/$JAVA_ARCHIVE $JAVA_DIRECTORY
chmod +755 $JAVA_DIRECTORY/$JAVA_ARCHIVE
cd $JAVA_DIRECTORY || exit
sudo tar -xzvf $JAVA_ARCHIVE

sudo echo "export JAVA_HOME=$JAVA_DIRECTORY/jdk-11.0.12" >> /home/vagrant/.bashrc
sudo echo "export PATH=$JAVA_DIRECTORY/jdk-11.0.12/bin:$PATH" >> /home/vagrant/.bashrc

echo "-------- Calling 'java' to output the currently used java version"
$JAVA_DIRECTORY/jdk-11.0.12/bin/java -version
