# API ENDPOINTS

## POST
`/shirts`  <br/>
- Criar nova camiseta

**Body**
```
}
	"title": "TITLE",
	"color": "COLOR",
	"description": "DESC",
	"type": "TYPE",
	"status": "STATUS"
}
```
## DELETE
`/shirts/{id}`  <br/>
- Deletar camiseta por id

## GET
`/shirts`  <br/>
- Listar todas as camisetas

`/shirts/available`  <br/>
- Listar todas as camisetas disponiveis

`/shirts/type/{type}`  <br/>
- Listar todas as camisetas por tipo/categoria

`/shirts/{id}`  <br/>
- Listar camiseta por id

## PUT
`/shirts/{id}`  <br/>
- Alterar camiseta por id

**Body**
```
}
	"title": "TITLE",
	"color": "COLOR",
	"description": "DESC",
	"type": "TYPE",
	"status": "STATUS"
}
```

## PATCH
`/shirts/{id}`  <br/>
- Alterar status por id

**Body**
```
}
	"status": "STATUS"
}
```

