#!/bin/bash

if [ $# -lt 2 ]
then
  echo "Not enough script parameters. Please type 'activity' and then names of environments e.g. run-env.sh start dev prod"
  exit
fi


for ((i = 2; i <= $#; i++ )); do
#  printf '%s\n' "Arg $i: ${!i}"

  cd ./env/"${!i}" || exit

  case $1 in
  "start")
  echo "Starting environment: ${!i}"
  vagrant up
  ;;

  "stop")
  echo "Stopping vagrant environment: ${!i}"
  vagrant halt
  ;;

  "destroy")
  echo "Destroying environment: ${!i}"
  vagrant destroy -f
  ;;

  "provision")
  echo "Provisioning environment: ${!i}"
  vagrant provision
  ;;

  "rebuild")
  echo "Rebuilding environment: ${!i}"
  vagrant destroy -f
  vagrant up
  ;;

  *)
  echo "Unknown command. Please try again."
  exit
  ;;
  esac

done
