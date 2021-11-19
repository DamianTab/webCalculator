
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
- **dev** - development environment where is code that is connected with VCS repository | candidate: http://192.168.33.08:8079
- **integration-server** - VM with Gitlab server and integration environment | gitlab http://192.168.33.9/gitlab
- **staging** - VM with staging environment | product: http://192.168.33.10:8081 (after executing test is not available)
- **prod** - VM with production environment | product: http://192.168.33.11:8082

### Main Script
Main script is **run.sh**:
`run.sh <objectives> <list of environments>`

Objectives:
- start - creates VM with environment
- stop - stops VM with environment
- destroy - destroys VM with environment
- rebuild - starts && destroys
- provision - performs only provisioning

### Gitlab

URL for gitlab server: http://192.168.33.9/gitlab

**Root user**
username: root
password: password
**Normal user** (Use only this one)
username: test
password: 12345678



## Guidelines

1. Get to the main directory of provided project (same place where is this readme.txt).
 2. Run bash script run.sh
 `sh run.sh start all`
 In case of resource using / long waiting time perform in this order: `integration-server, dev, staging, prod`




## Test Case

Initial conditions: none

All tests are performed automatically without user interaction. It is possible to run unit test with maven.

- unit tests -> mvn test
- integration tests -> mvn verify

Running tests on staging environment is performed with special WAR package that contains test classes.
