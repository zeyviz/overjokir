## 🛡️ um mini projeto Java Pentest 

### scanner port
Um scanner de portas TCP que identifica serviços ativos em um intervalo definido.
ele Mapeamento de serviços comuns (SSH, HTTP, FTP, etc)
e Gera automaticamente um arquivo `scannerPort.txt` com os resultados.

### retry scanner
Uma ferramenta de persistência para testar a estabilidade de portas específicas.
ela Tenta estabelecer conexão varias vezes antes de desistir.

## como executar

**Compile o arquivo desejado:**
   ```bash
   javac RetryScanner.java
```

  ```bash
  java RetryScanner
  ```
