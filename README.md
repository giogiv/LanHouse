Projeto – Sistema de Lan House

Este projeto foi desenvolvido como parte de um trabalho da faculdade e simula o funcionamento básico de uma Lan House, incluindo controle de computadores, clientes, funcionários e sessões de uso.

📌 Sobre o Sistema

O sistema é baseado no gerenciamento de horas de uso e no estado dos computadores (livre, ocupado ou em manutenção).
Ele permite cadastrar e controlar alguns elementos presentes em uma lan house real.

🧱 Classes do Sistema

O projeto contém as seguintes classes principais:

Computador – Representa cada máquina da lan house e seu estado (livre/ocupado).
Cliente – Usuários que utilizam os computadores.
Funcionário – Pessoas responsáveis pelo atendimento.
Pessoa – Classe base para Cliente e Funcionário.
Sessão – Registra o uso do computador por um cliente, com hora inicial e final.
Venda – Gerada após o encerramento de uma sessão.

⚙️ Funcionalidades
✔️ Cadastros
✔️ Telas
✔️ Modelos
✔️ Modelos Dao

✔️ Gerenciamento de Sessões

Uma sessão deve ter:
Um cliente
Um computador
A hora inicial
Valor por hora

Se a hora final não for informada, o computador permanece ocupado.
Ao informar a hora final, o computador passa para o estado livre.
Apenas computadores livres podem receber novas sessões.

✔️ Controle de Ocupação

O sistema impede criar sessão em computadores que já estejam ocupados.
Somente após encerrar uma sessão, a venda pode ser realizada.

✔️ Valor da Sessão Baseado nas Horas

Quando o cliente for realizar a venda, ele vai estar em uma sessão.
Essa sessão é selecionada e automaticamente preenche o valor calculado pela hora inicial
e pela hora final cadastrada na sessão.

🎯 Objetivo do Projeto

Demonstrar, de forma simples, como funciona o gerenciamento de uma lan house, praticando conceitos de:
Orientação a Objetos
Relacionamento entre classes
Regras de negócio
Lógica de controle de estado
