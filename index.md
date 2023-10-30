
# ecommerce



<!--- If we have only one group/collection, then no need for the "ungrouped" heading -->



## Endpoints

* [user](#user)
    1. [createUser](#1-createuser)
    1. [readUser](#2-readuser)
    1. [updateUser](#3-updateuser)
    1. [deleteUser](#4-deleteuser)
    1. [readAllUsers](#5-readallusers)
* [product](#product)
    1. [createProduct](#1-createproduct)
    1. [readProduct](#2-readproduct)
    1. [updateProduct](#3-updateproduct)
    1. [deleteProduct](#4-deleteproduct)
    1. [readAllProducts](#5-readallproducts)
* [sale](#sale)
    1. [createSale](#1-createsale)
    1. [readSaleByUserId](#2-readsalebyuserid)
    1. [deleteSale](#3-deletesale)
    1. [updateSale](#4-updatesale)
    1. [readBySaleId](#5-readbysaleid)
    1. [readAllSales](#6-readallsales)
* [saleProduct](#saleproduct)
    1. [createSaleProduct](#1-createsaleproduct)
    1. [readSaleProduct](#2-readsaleproduct)
    1. [readAllSaleProduct](#3-readallsaleproduct)
    1. [updateSaleProduct](#4-updatesaleproduct)
    1. [deleteSaleProduct](#5-deletesaleproduct)

--------



## user



### 1. createUser



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8080/user/
```



***Body:***

```js        
{
  "email": "teste@teste.com",
  "address": "R. Teste 123",
  "name": "Teste 2",
  "password": "123",
  "username": "bardequito"
}
```



### 2. readUser



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/user/
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| id | b2c72434-4fd0-425f-bc2e-f02a51a2cd49 |  |



### 3. updateUser



***Endpoint:***

```bash
Method: PATCH
Type: RAW
URL: http://localhost:8080/user/
```



***Body:***

```js        
{
  "id": "b2c72434-4fd0-425f-bc2e-f02a51a2cd49",
  "email": "otavio.silva@teste.com",
  "address": "R. Teste 12",
  "name": "Teste",
  "password": "123",
  "username": "bardequito"
}
```



### 4. deleteUser



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8080/user/
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| id | b2c72434-4fd0-425f-bc2e-f02a51a2cd49 |  |



### 5. readAllUsers



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/user/all
```



## product



### 1. createProduct



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8080/product/
```



***Body:***

```js        
{
  "description": "Produto de limpeza",
  "lable": "Detergente",
  "price": 2.0,
  "quantity": 2,
  "code": "54321"
}
```



### 2. readProduct



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/product/
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| id | 6d98bae2-55f8-43a5-9236-6de56d9e79f2 |  |



### 3. updateProduct



***Endpoint:***

```bash
Method: PATCH
Type: RAW
URL: http://localhost:8080/product/
```



***Body:***

```js        
{
  "id": "362a9a8b-970a-4831-a667-7f692714d2f4",
  "code": "12345",
  "lable": "Sabão em pó",
  "description": "Produto de limpeza",
  "quantity": 10,
  "price": 2.0,
  "createdAt": "2023-10-30T16:03:43.10227"
}
```



### 4. deleteProduct



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8080/product/
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| id | 6d98bae2-55f8-43a5-9236-6de56d9e79f2 |  |



### 5. readAllProducts



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/product/all
```



## sale



### 1. createSale



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8080/sale/
```



***Body:***

```js        
{
  "userId": "7094017d-eb1c-4fbc-b0d7-fee38f9bbcdb",
  "total": 0
}
```



### 2. readSaleByUserId



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/sale/
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| id | 7094017d-eb1c-4fbc-b0d7-fee38f9bbcdb |  |



### 3. deleteSale



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8080/sale/
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| id | 082ab1d4-d25a-4945-8ace-594876a28925 |  |



### 4. updateSale



***Endpoint:***

```bash
Method: PATCH
Type: RAW
URL: http://localhost:8080/sale/
```



***Body:***

```js        
{
  "id": "82846e54-4565-4ae1-8119-0681c6d33cfa",
  "userId": "7094017d-eb1c-4fbc-b0d7-fee38f9bbcdb",
  "total": 0,
  "createdAt": "2023-10-30T16:04:08.877829"
}
```



### 5. readBySaleId



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/sale/idSale
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| id | 082ab1d4-d25a-4945-8ace-594876a28925 |  |



### 6. readAllSales



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/sale/all
```



## saleProduct



### 1. createSaleProduct



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8080/saleProduct/
```



***Body:***

```js        
{
  "saleId": "82846e54-4565-4ae1-8119-0681c6d33cfa",
  "productId": "362a9a8b-970a-4831-a667-7f692714d2f4",
  "quantity": 2
}
```



### 2. readSaleProduct



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/saleProduct/id=
```



### 3. readAllSaleProduct



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/saleProduct/all
```



### 4. updateSaleProduct



***Endpoint:***

```bash
Method: PATCH
Type: RAW
URL: http://localhost:8080/saleProduct/
```



***Body:***

```js        
{
  "id": "e3ace45d-ff6c-48b5-862b-5c3c6130f420",
  "saleId": "82846e54-4565-4ae1-8119-0681c6d33cfa",
  "productId": "362a9a8b-970a-4831-a667-7f692714d2f4",
  "quantity": 0,
  "createdAt": "2023-10-30T16:55:01.511934"
}
```



### 5. deleteSaleProduct



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8080/saleProduct/
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| id | 1bd003c2-7e64-45bd-beb4-a832964a132d |  |



---
[Back to top](#ecommerce)

>Generated at 2023-10-30 17:59:04 by [docgen](https://github.com/thedevsaddam/docgen)
