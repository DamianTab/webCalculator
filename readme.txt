
# Deployment pipeline project - Damian Tabaczyński


## Asset composition and technologies

- a vagrant VM specification (i.e. Vagrant file)
- Ansible playbooks to provision the VM
- GitLab as VCS (git) and CI running into the VM
- Nodejs, Angular 12 as frontend
- Oracle JDK11, Maven and SpringBoot in backend


## Prerequisites

### Hardware
1. Laptop/PC with at least 8 Gb memory (recommended 16 Gb, ideally 32 Gb).
I want to emphasise that 8GB is exactly minimum. Author of this project does not take responsibility for very long processing time due to this fact.

### Software
1. Linux-like host operating system (e.g. OS Ubuntu 18.04+)
2. VirtualBox(v 6.0, or higher)
3. Vagrant (v 2.2.5, or higher)
4. Ansible (v 2.7.5, or higher)

  ## Basic Information
  Whole project is **completely automatic**. There is no phase that requires interaction with user except first script run to create all necessary environments and tools.  In other words after pushing changes from development environment to VCS repository - whole process of building, testing, deploying and releasing candidate/product  is self-sufficient. All tasks like creating user, copying code to dev-env, changing passwords creating gitlab-runners etc. are as much non-interactive as creating vagrant VM or provisiongi through Ansible. More examples in *scenario.txt*

### VMs (environments)
- **dev** - development environment where is code that is connected with VCS repository
- **integration-server** - VM with Gitlab server and integration environment
- **staging** - VM with staging environment
- **prod** - VM with production environment

### Main Script
Main script is **run.sh**:
`run.sh <objectives> <list of environments>`

Objectives:
- start - creates VM with environment
- stop - stops VM with environment
- destroy - destroys VM with environment
- rebuild - starts && destroys
- provision - performs only provisioning


## Guidelines

1. Get to the main directory of provided project (same place where is this readme.txt).
 2. Run bash script run.sh
 `sh run.sh start all`
 In case of resource using / long waiting time perform in this order: `integration-server, dev, staging, prod`


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
