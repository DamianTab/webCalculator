#!/bin/bash
case $1 in
"start")
echo "Start" ;;
"stop")
echo "Stop" ;;
*)
echo "Unknown command. Please write 'start' to start project or 'stop' to shutdown all project processes" ;;
esac