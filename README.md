# Membership

Create a new Roles service that enhances the Users and Teams services

## How to run

```sh
docker-compose up
```

## Technologies

- Java 19
- Spring boot
- hsqldb
- Caffeine Cache

## Core features

- Create a new role
- Assign a role to a team member
- Look up a role for a membership
  - A membership is defined by a user id and a team id.
- Look up memberships for a role

## Endpoints

[here](api.http)

## Github Repository

[here](https://github.com/pablo-ungaro/membership)


