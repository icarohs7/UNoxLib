# Instruções para se lançar uma nova versão
## URL com detalhes: http://www.lordgeekcafe.com.br/maven-central-como-publicar-sua-lib-java/

0. atualizar versão no POM, versão essa que será utilizada nos passos 3 e 4
0. fazer commit e push do update
0. definir tag no git: git tag **versão** seguido de git push --tag
0. atualizar no arquivo release.properties:**\~desnecessário no gradle\~**<br>
	scm.url=scm:git:https://github.com/icarohs7/UNoxLib.git<br>
	scm.tag=v${versão}<br>
0. mvn release:perform **\~desnecessário no gradle\~**
0. **pedir a Deus para funcionar**
0. Acesse o Sonartype OSS (https://oss.sonatype.org)
0. Faça login
0. Selecione o menu Staging Repositories
0. Encontre o seu repositório
0. Selecione o repositório. Ele deve estar aberto (“open”)
0. Clique no botão de fechar (“close”) na barra superior. 
	A aba “Content” irá sumir e verifique que nas atividades (“activity”) o fechamento ocorreu com sucesso.
	Se tudo ocorrer como esperado, você receberá um e-mail automático em poucos minutos indicando “Staging Completed”
0. Clique no botão “Refresh” e veja que o seu repositório está fechado;
0. Selecione-o novamente e clique em “Release”.
	Se der tudo certo novamente, você receberá outro e-mail automático indicando “Promotion Completed”.