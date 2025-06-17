# ms-productos-backend
Microservicio de productos para el proyecto final del curso de Docker y Kubernetes Básico

## Instalacion
Ejecutar los siguientes comandos para desplegar el microservicio:
```
kubectl apply -f ms-productos-backend-configmap.yml
kubectl apply -f ms-productos-backend-pv.yml
kubectl apply -f ms-productos-backend-pvc.yml
kubectl apply -f ms-productos-backend-deployment.yml
kubectl apply -f ms-productos-backend-service.yml
kubectl apply -f ms-productos-backend-ingress.yml
```

## Uso
| Metodo | Url                    | Descripción                      |
|--------|------------------------|----------------------------------|
| GET    | /api/v1/productos      | Listar todos los productos       |
| GET    | /api/v1/productos/{id} | Obtener producto por ```id```    |
| POST   | /api/v1/productos      | Crear producto                   |
| PUT    | /api/v1/productos/{id} | Actualizar producto por ```id``` |
| DELETE | /api/v1/productos/{id} | Eliminar producto por ```id```   |
