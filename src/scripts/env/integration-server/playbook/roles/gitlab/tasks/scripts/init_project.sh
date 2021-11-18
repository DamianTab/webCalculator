#!/bin/bash

echo "Generating token"
gitlab-rails runner "token = User.find_by_username('root').personal_access_tokens.create(scopes: [:read_user, :read_repository, :api, :read_api], name: 'Automation token'); token.set_token('this_is_my_private_token'); token.save!"
echo "Creating user"
curl -X POST --header "PRIVATE-TOKEN: this_is_my_private_token" --data "username=test&password=12345678&email=test@test.com&name=Damian Tabaczynski&skip_confirmation=true" "http://localhost/gitlab/api/v4/users"
echo "Creating project"
curl -X POST --header "PRIVATE-TOKEN: this_is_my_private_token" --data "name=webCalculator" "http://localhost/gitlab/api/v4/projects/user/2"