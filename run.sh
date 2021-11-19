#!/bin/bash

ENV_SCRIPTS="./src/scripts"
ENV_SCRIPT="run_env.sh"

cd $ENV_SCRIPTS || exit

sh $ENV_SCRIPT "$@"