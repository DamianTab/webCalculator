#!/bin/bash

ENV_SCRIPTS="./src/scripts"
ENV_SCRIPT="run_env.sh"

cd $ENV_SCRIPTS || exit

if [ "$2" = "all" ]
then
  sh $ENV_SCRIPT "$1" "integration-server" "dev" "staging" "prod"
else
  sh $ENV_SCRIPT "$@"
fi


