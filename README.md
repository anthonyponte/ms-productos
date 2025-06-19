# ms-productos-backend
Microservicio de productos para el proyecto final del curso de Docker y Kubernetes Básico

## Requisitos
- H2 Database Engine

## Instalacion
Ejecutar los siguientes comandos para desplegar H2 Database Engine:

```
kubectl apply -f h2-pvc.yaml
kubectl apply -f h2-deployment.yaml
kubectl apply -f h2-service.yaml
```

Ejecutar los siguientes comandos para desplegar el microservicio:
```
kubectl apply -f ms-productos-backend-deployment.yaml
kubectl apply -f ms-productos-backend-service.yaml
```

## Uso
| Metodo | Url                    | Descripción                      |
|--------|------------------------|----------------------------------|
| GET    | /api/v1/productos      | Listar todos los productos       |
| GET    | /api/v1/productos/{id} | Obtener producto por ```id```    |
| POST   | /api/v1/productos      | Crear producto                   |
| PUT    | /api/v1/productos/{id} | Actualizar producto por ```id``` |
| DELETE | /api/v1/productos/{id} | Eliminar producto por ```id```   |
