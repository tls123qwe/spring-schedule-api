# 📡 API 상세 명세

모든 요청과 응답은 `Content-Type: application/json`을 사용합니다.

---

## 1. 일정 생성

`POST /schedules`

### Request Body
```json
{
  "writer": "요시",
  "title": "스프링 공부",
  "contents": "JPA 영속성 컨텍스트 정리하기",
  "password": "1234"
}
```

### Response `201 Created`
```json
{
  "id": 1,
  "writer": "요시",
  "title": "스프링 공부",
  "contents": "JPA 영속성 컨텍스트 정리하기",
  "createdAt": "2026-06-30T10:00:00",
  "modifiedAt": "2026-06-30T10:00:00"
}
```

| Code | Description |
| --- | --- |
| 201 Created | 일정 생성 성공 |
| 400 Bad Request | 필수값 누락 등 잘못된 요청 |

---

## 2. 전체 / 작성자별 조회

`GET /schedules`  
`GET /schedules?writer={writer}`

`writer`를 전달하지 않으면 전체 일정을, 전달하면 해당 작성자의 일정만 조회합니다.

### Query Parameter
| Name | Type | Required | Description |
| --- | --- | --- | --- |
| writer | String | X | 작성자 이름 |

### Response `200 OK`
```json
[
  {
    "id": 1,
    "writer": "요시",
    "title": "스프링 공부",
    "contents": "JPA 영속성 컨텍스트 정리하기",
    "createdAt": "2026-06-30T10:00:00",
    "modifiedAt": "2026-06-30T10:00:00"
  }
]
```

---

## 3. 단건 조회

`GET /schedules/{id}`

### Path Variable
| Name | Type | Description |
| --- | --- | --- |
| id | Long | 조회할 일정 ID |

### Response `200 OK`
```json
{
  "id": 1,
  "writer": "요시",
  "title": "스프링 공부",
  "contents": "JPA 영속성 컨텍스트 정리하기",
  "createdAt": "2026-06-30T10:00:00",
  "modifiedAt": "2026-06-30T10:00:00"
}
```

| Code | Description |
| --- | --- |
| 200 OK | 조회 성공 |
| 404 Not Found | 존재하지 않는 일정 |

---

## 4. 일정 수정

`PUT /schedules/{id}`

등록된 비밀번호와 일치할 때만 수정됩니다.

### Request Body
```json
{
  "writer": "요시",
  "title": "스프링 복습",
  "contents": "Dirty Checking 정리하기",
  "password": "1234"
}
```

### Response `200 OK`
```json
{
  "id": 1,
  "writer": "요시",
  "title": "스프링 복습",
  "contents": "Dirty Checking 정리하기",
  "createdAt": "2026-06-30T10:00:00",
  "modifiedAt": "2026-06-30T11:30:00"
}
```

| Code | Description |
| --- | --- |
| 200 OK | 수정 성공 |
| 400 Bad Request | 비밀번호 불일치 |
| 404 Not Found | 존재하지 않는 일정 |

---

## 5. 일정 삭제

`DELETE /schedules/{id}`

등록된 비밀번호와 일치할 때만 삭제됩니다.

### Request Body
```json
{
  "password": "1234"
}
```

| Code | Description |
| --- | --- |
| 204 No Content | 삭제 성공 |
| 400 Bad Request | 비밀번호 불일치 |
| 404 Not Found | 존재하지 않는 일정 |
