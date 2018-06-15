# Instruções para se lançar uma nova versão
## URL com detalhes: http://www.lordgeekcafe.com.br/maven-central-como-publicar-sua-lib-java/

1. atualizar versão no POM, versão essa que será utilizada nos passos 3 e 4
2. fazer commit e push do update
3. definir tag no git: git tag **versão** seguido de git push --tag
4. atualizar no arquivo release.properties:
	scm.url=scm:git:https://github.com/icarohs7/UNoxLib.git
	scm.tag=v${versão}
5. mvn release:perform
6. **pedir a Deus para funcionar**
7. Acesse o Sonartype OSS (https://oss.sonatype.org)
8. Faça login
9. Selecione o menu Staging Repositories
10. Encontre o seu repositório
11. Selecione o repositório. Ele deve estar aberto (“open”)
12. Clique no botão de fechar (“close”) na barra superior. 
	A aba “Content” irá sumir e verifique que nas atividades (“activity”) o fechamento ocorreu com sucesso.
	Se tudo ocorrer como esperado, você receberá um e-mail automático em poucos minutos indicando “Staging Completed”
13. Clique no botão “Refresh” e veja que o seu repositório está fechado;
14. Selecione-o novamente e clique em “Release”.
	Se der tudo certo novamente, você receberá outro e-mail automático indicando “Promotion Completed”.