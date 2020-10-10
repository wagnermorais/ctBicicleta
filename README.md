# ctBicicleta

Para gerar a Imagem docker (plugin maven):

clean package fabric8:build -DskipTests


K8s

kubectl apply -f deploy.yaml (pasta Deploy)
kubectl apply -f service.yaml (pasta Deploy)

Acesso pela porta do nodeport

http://localhost:31514/swagger-ui.html



obs:
Gostaria de ter dito tempo para fazer mais coisas com usar jwt, documentação, monitoramente etc..
Mas foi o que consegui fazer conciliando com o trabalho e o prazo curto.
att;