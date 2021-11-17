#!/bin/bash

PROJECT_PATH=$(pwd)
LIB_PATH="$PROJECT_PATH/lib"
ENV_SCRIPTS="./src/scripts"
ENV_SCRIPT="env.sh"

cd $ENV_SCRIPTS || exit

case $1 in
"create")
echo "Creating all environments"
;;

"start")
echo "Start"
sh $ENV_SCRIPT prod start
;;

"stop")
echo "Stop"
sh $ENV_SCRIPT prod stop
;;

"destroy")
echo "destroy"
sh $ENV_SCRIPT prod destroy
;;

*)
echo "Unknown command. Please write 'start' to start project or 'stop' to shutdown all project processes" ;;
esac