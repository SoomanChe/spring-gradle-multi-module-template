# Spring Webflux multi module starter template

## Overview
`Work In Progress`

## Design
* Domain base structure.
* CQRS pattern.
  * Minimize repository methods. 
  * Referred to [How to hide Spring data repository methods](https://www.amitph.com/spring-data-repository-hide-methods/)
    
## Test
* Test With Kotest
* Describe-Context-It pattern.
* Manually set transactions with `TransactionOperator` at @DataR2dbcTest
  * [@Transactional not work in TestContext of reactive app](https://github.com/spring-projects/spring-framework/issues/24226)
    
## Work todo
- [x] repository test example
- [ ] service test example
- [ ] controller test example
- [ ] rest docs example
