## PROJETO DIO - SUDOKU

Este projeto foi feito para resolver o desafio da DIO, consistindo basicamente na implementação de um sudoku com as seguintes _features_:

0. Deve-se ter um menu interativo onde poderemos escolher entre as opções abaixo.
1. Iniciar um novo o jogo: Deve-se exibir na tela o jogo inicial, com os espaços preenchidos somente pelos números iniciais (usar os args do método main para informar os números iniciais e suas devidas posiçõers);
2. Colocar um novo número: Deve-se solicitar as seguintes informações do jogador (número a ser colocado, indice horizontal e indice vertical do número), não se deve permitir que seja colocado um número em uma posição que já esteja preenchida ( seja número fixo ou informado pelo jogador);
3. Remover um número: deve-se solicitar os índices verticais e horizontais do número que deseja remover ( caso o número seja um número fixo do jogo deve-se exibir uma mensagem informado que o número não pode ser removido);
4. Verificar jogo: Visualizar a situação atual do jogo;
5. Verificar status do jogo: Deve-se verificar o status atual do jogo ( não iniciado, incompleto e completo) e se contém ou não erros ( o jogo está errado quando tem números em posições conflitantes) todos os status do jogo podem conter ou não erros, exceto o status não iniciado que é sempre sem erro;
6. Limpar: remove todos os números informados pelo usuário e mantém os fixos do jogo;
7. finalizar o jogo: Se o jogo estiver com todos os espaços preenchidos de forma válida o jogo é encerrado, senão informar ao usuário que ele deve preencher todos os espaços com seus respectivos números;

Inicialmente, fiz não olhando a forma como o professor resolveu o desafio, pois a minha intenção é realmente exercitar a habilidade de encontrar soluções por conta própria.

Atualmente estou trabalhando da seguinte forma nesse projeto:
1. Branch master é a branch de produção, branch develop é a branch de homologação, demais branches são as implementações das issues.
2. Toda issue aberta é uma task que precisa ser fechada.

Estou estudando a futura implementação de uma esteira automatizada que faça o build automático do .jar e lance uma nova release automaticamente.