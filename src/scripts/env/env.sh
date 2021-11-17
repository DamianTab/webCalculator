#!/bin/bash

cd ./"$1" || exit


case $2 in
"start")
echo "Starting environment: $1"
vagrant up
;;

"stop")
echo "Halting vagrant environment: $1"
vagrant halt
;;

"destroy")
echo "Destroying environment: $1"
vagrant destroy -f
;;

*)
echo "Unknown command. Please try again." ;;
esac
