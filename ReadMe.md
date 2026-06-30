## 일정 생성

- **Method** : POST
- **URL** : `/schedules`
- **Description**
    - 새로운 일정을 생성합니다.

### Request

#### Header

| Key | Value |
|------|-------|
| Content-Type | application/json |

#### Body

```json
{
  "writer": "작성자",
  "title": "일정 제목",
  "contents": "일정 내용",
  "password": "비밀번호"
}
```

### Response

#### Status Code

| Code | Description |
|------|-------------|
| 201 Created | 일정 생성 성공 |
| 400 Bad Request | 잘못된 요청 |

#### Body

```json
{
  "id": 1,
  "writer": "작성자",
  "title": "일정 제목",
  "contents": "일정 내용",
  "createdAt": "...",
  "modifiedAt": "..."
}
```
---
## 일정 조회

### 전체 조회

- **Method** : GET
- **URL** : `/schedules`
- **Description**
    - 모든 일정을 조회합니다.

### Response

| Code | Description |
|------|-------------|
| 200 OK | 조회 성공 |

#### Body

```json
[
  {
    "id": 1,
    "writer": "작성자",
    "title": "일정 제목",
    "contents": "일정 내용",
    "createdAt": "...",
    "modifiedAt": "..."
  }
]
```
---
## 일정 조회

### 단건 조회

- **Method** : GET
- **URL** : `/schedules/{id}`
- **Description**
    - ID에 해당하는 일정을 조회합니다.

### Path Variable

| Name | Type | Description |
|------|------|-------------|
| id | Long | 조회할 일정 ID |

### Response

| Code | Description |
|------|-------------|
| 200 OK | 조회 성공       |
| 404 Not Found | 없는 일정입니다.   |

#### Body

```json
{
  "id": 1,
  "writer": "작성자",
  "title": "일정 제목",
  "contents": "일정 내용",
  "createdAt": "...",
  "modifiedAt": "..."
}
```
---
## 일정 조회

### 작성자 조회

- **Method** : GET
- **URL** : `/schedules?writer={writer}`
- **Description**
    - 작성자 이름으로 일정을 조회합니다.

### Query Parameter

| Name | Type | Description |
|------|------|----------|
| writer | String | 작성자 |

### Response

| Code | Description |
|------|-------------|
| 200 OK | 조회 성공 |

#### Body

```json
[
  {
    "id": 1,
    "writer": "작성자",
    "title": "일정 제목",
    "contents": "일정 내용",
    "createdAt": "...",
    "modifiedAt": "..."
  }
]
```
---
## 일정 수정

- **Method** : PUT
- **URL** : `/schedules/{id}`
- **Description**
    - 해당 ID의 일정을 수정합니다.
    - 등록된 비밀번호와 입력한 비밀번호가 일치하는 경우에만 수정이 가능합니다.

### Path Variable

| Name | Type | Description |
|------|------|-------------|
| id | Long | 수정할 일정 ID   |

### Request

#### Body

```json
{
  "writer": "수정자",
  "title": "수정 제목",
  "contents": "수정 내용",
  "password": "비밀번호"
}
```

### Response

| Code | Description      |
|------|------------------|
| 200 OK | 수정 성공            |
| 400 Bad Request | 비밀번호가 일치하지 않습니다. |
| 404 Not Found | 없는 일정입니다.        |
#### Body

```json
[
  {
    "id": 1,
    "writer": "수정자",
    "title": "수정 제목",
    "contents": "수정 내용",
    "createdAt": "...",
    "modifiedAt": "수정 날짜 및 시간"
  }
]
```
---
## 일정 삭제

- **Method** : DELETE
- **URL** : `/schedules/{id}`
- **Description**
    - 해당 ID의 일정을 삭제합니다.
    - 등록된 비밀번호와 입력한 비밀번호가 일치하는 경우에만 삭제가 가능합니다.

### Path Variable

| Name | Type | Description |
|------|------|-------------|
| id | Long | 삭제할 일정 ID |

### Request

#### Body

```json
{
  "password": "비밀번호"
}
```

### Response

| Code | Description      |
|--|------------------|
| 204 No Content | 삭제 성공            |
| 400 Bad Request | 비밀번호가 일치하지 않습니다. |
| 404 Not Found | 없는 일정입니다.        |
---

## ERD

| 컬럼명 | 타입           | 제약조건 | 설명 |
|--------|--------------|---------|------|
| id | BIGINT       | PK, AUTO_INCREMENT | 일정 고유 번호 |
| writer | VARCHAR(100) | NOT NULL | 작성자 |
| title | VARCHAR(200) | NOT NULL | 일정 제목 |
| contents | TEXT         | NOT NULL | 일정 내용 |
| password | VARCHAR(255) | NOT NULL | 수정 및 삭제 시 사용할 비밀번호 |
| created_at | TIMESTAMP    | NOT NULL | 생성 일시 |
| modified_at | TIMESTAMP     | NOT NULL | 수정 일시 |