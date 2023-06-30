<div align="center">

[![Maven build, test, and dependency graph generation](https://github.com/ConservationColorado/java-oauth2-client-starter/actions/workflows/maven-build-test-dependency-graph.yml/badge.svg)](https://github.com/ConservationColorado/java-oauth2-client-starter/actions/workflows/maven-build-test-dependency-graph.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-success.svg)](https://www.gnu.org/licenses/gpl-3.0)

</div>

# Welcome to `java-oauth2-client-starter`!

## 🔗 [Blog post: Spring OAuth Client With A Test-Driven Approach](https://tech.conservationco.org/blog/spring-oauth-client-with-a-test-driven-approach/)

This repository is home to a Spring server written in Java to help you get started building an OAuth2 client
application!

When I first implemented an OAuth2.0 client application at our organization, configuring our reactive Spring application
correctly and securely took lots of time to figure out! The above guide and this repository are what I wish I had when I
was doing that work.

## What it does

Implements a reactive Spring OAuth client with login and logout, which will allow you to request users to authorize
OpenID Connect scopes like `openid`, `profile`, `email` as well as OAuth2 scopes specific to your provider.

## Getting started

### Steps to get a copy of this repository

There are a few ways to get a copy of this repository.

1. Using the `git` command in your terminal:

```shell
git clone git@github.com:ConservationColorado/java-oauth2-client-starter      # over SSH
git clone https://github.com/ConservationColorado/java-oauth2-client-starter  # over HTTPS
```

2. Using the `wget` command in your terminal:

```shell
wget -Q https://github.com/ConservationColorado/java-oauth2-client-starter/archive/refs/heads/main.zip && unzip -q main.zip
```

3. Alternatively, you can
   [download a `.zip` file containing of the main branch at this link](https://github.com/ConservationColorado/java-oauth2-client-starter/archive/refs/heads/main.zip),
   then extract the contents with your operating system's file explorer.

### Environment variables

To run the app, you'll need to supply the environment variables specified as _required_ below. You can acquire these
from your OAuth provider.

| Variable        | Required? | Description                        |
|-----------------|:---------:|:-----------------------------------|
| `CLIENT_ID`     |     Y     | Your application's `client_id`     |
| `CLIENT_SECRET` |     Y     | Your application's `client_secret` |

Don't forget to reference your provider's name in
[this line of configuration](https://github.com/ConservationColorado/java-oauth2-client-starter/blob/259f36a0489973dd71148fffcd3eb829d470e79a/src/main/resources/application.yml#L6).

### Dependencies

Skip this step if you've cloned this repository. These are already included in this project (view the full
[dependency graph at this link](https://github.com/ConservationColorado/java-oauth2-client-starter/network/dependencies?q=spring)).

If you’re starting from scratch with [start.spring.io](https://start.spring.io) or IntelliJ’s Spring project creator,
include these dependencies:

* Spring Reactive Web
* Spring Security
* Spring Security OAuth 2 Client
