# Sistema de Controle de Clínica Médica — Saúde & Cia

## Descrição do Projeto

Este projeto consiste em um sistema de controle para a clínica médica "Saúde & Cia", desenvolvido em Java para gerenciar pacientes, consultas e prontuários médicos. O sistema visa substituir o método manual em papel pela gestão informatizada em memória, agilizando processos operacionais da clínica.

---

## Funcionalidades

### Perfil Secretária
- Gerenciamento de pacientes (cadastro, atualização e remoção), incluindo dados pessoais, contato, endereço e tipo de convênio (particular ou plano de saúde).
- Gerenciamento de consultas (cadastro, atualização e remoção), com informações sobre data, horário, médico, paciente e tipo de consulta (normal ou retorno).
- Geração de relatórios com consultas agendadas para o dia seguinte, com filtros baseados na presença de e-mail e/ou celular.

### Perfil Médico
- Gerenciamento de dados complementares de saúde dos pacientes (fuma, bebe, colesterol, diabetes, doenças cardíacas, cirurgias, alergias), acessível somente ao médico.
- Gerenciamento do prontuário dos pacientes, incluindo sintomas, diagnóstico e prescrição.
- Geração de relatórios médicos: receitas, atestados, declarações de acompanhamento e clientes atendidos no mês.

### Gerenciador de Mensagens
- Simulação do envio de notificações via e-mail ou SMS para os pacientes, lembrando-os das consultas agendadas para o dia seguinte.

---

## Tecnologias e Conceitos Utilizados

- Linguagem: Java 
- Utilização de JavaBeans/POJOs para encapsulamento dos dados.
- Separação de responsabilidades em pacotes conforme o perfil e função das classes.
- Armazenamento exclusivamente em memória primária (coleções e arrays).
- Sistema sem interface gráfica elaborada, com foco no funcionamento das classes.
- Uso adequado de modificadores de acesso, herança e encapsulamento.

---

## Divisão dos Pacotes

Para garantir uma boa **separação de responsabilidades** e organizar o sistema conforme os conceitos de boa engenharia de software, as classes foram divididas em quatro pacotes principais:

- **`Dados`**  
  Contém todas as classes POJOs que modelam os dados da clínica, são elas:  
  - `Paciente`  
  - `Consulta`  
  - `Prontuario`  
  - `Relatorio`

- **`Funcionarios`**  
  Contém as classes que representam os funcionários da clínica com responsabilidades específicas:  
  - `Secretaria`  
  - `Medico`

- **`GerenciadorMensagens`**  
  Pacote dedicado ao gerenciamento do envio de mensagens para os pacientes, contendo a classe:  
  - `GerenciadorMensagens`

- **`Execucao`**  
  Contém a classe principal `Main`, responsável por executar e testar as funcionalidades do sistema.
