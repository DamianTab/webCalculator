# CI server


## Asset composition

- a vagrant VM specification (i.e. Vagrant file)
- Ansible playbooks to provision the VM
- GitLab as VCS and CI running into the VM
- Docker service running into the VM




## Prerequisites

### Hardware

1. Laptop with at least 8 Gb memory (recommended 16 Gb, ideally 32 Gb)


### Software

1. OS Ubuntu 18.04
2. VirtualBox(v 6.0, or higher)
3. Vagrant (v 2.2.5, or higher)
4. Ansible (v 2.7.5, or higher)




## Guidelines


1- Get to the working directory

cd ~/<git_root_folder>/devops/pipeline/s2-automate-build/integration-server


2- Vagrant is used to create a VM which acts as integration server.

vagrant up



3- Edit /etc/gitlab/gitlab.rb and replace

external_url http://hostname

by

external_url 'http://192.168.33.9/gitlab'

and

unicorn['port'] = 8080

by

unicorn['port'] = 8088


(Don't forget to uncomment)


4- Reconfigure and restart gitlab

4.1 sudo gitlab-ctl reconfigure

4.2 sudo gitlab-ctl restart unicorn

4.3 sudo gitlab-ctl restart



### **** Test Case ****

Initial conditions: none

Test Steps:
1. Go to http://192.168.33.9/gitlab

Post conditions:
- GitLab is accessible at the indicated URL
- It asks to enter passwork for the root creedentials



5- Set password for admin user

5.1 Enter password (refered as $YOUR_PASSWORD later) for the root credentials.



### **** Test Case ****

Initial conditions: you have successfully entered a password for the root credentials

Test Steps:

1. Go to http://192.168.33.9/gitlab
2. Log in using as user name "root" and password the one entered in the previous step.


Post conditions:
- You have successfully logged in as administrator


