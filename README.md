# ctBicicleta

Para gerar a Imagem docker (plugin maven):

clean package fabric8:build -DskipTests


K8s

kubectl apply -f deploy.yaml (pasta Deploy)
kubectl apply -f service.yaml (pasta Deploy)

Acesso pela porta do nodeport

http://localhost:31514/swagger-ui.html



