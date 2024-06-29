# Touch and Test App

**Read this in other languages**: [English](#english) | [Português](#português)

## <a name="english"></a>English

A Jetpack Compose Android application that displays a grid of buttons. Each button can be disabled when clicked, and the grid state is managed by a ViewModel. The application also features a countdown timer and timeout messages.

### Overview

This project is an example of using Jetpack Compose to create a responsive user interface that displays a grid of buttons. Each button in the grid can be clicked to be disabled, and the state is managed by a ViewModel. The application includes a countdown timer and feedback messages to the user.

### Features

- Displays a grid of 36 buttons arranged in 9 rows and 4 columns.
- Each button can be clicked to be disabled.
- The grid state is managed using LiveData in the ViewModel.
- 10-second countdown timer to complete the test.
- Displays success or failure messages based on the test result.
- Dynamic UI update based on the observed state.

### Screenshots

<table>
  <tr>
    <td><img src="https://github.com/Bonnivaldo/TouchAndTest/assets/53324114/81aeccc0-5542-4f95-8310-8fad0f265615" alt="initial view" width="200"/></td>
    <td><img src="https://github.com/Bonnivaldo/TouchAndTest/assets/53324114/959c4bfe-4b25-479a-9d98-db008d8bbe69" alt="initial grid" width="200"/></td>
    <td><img src="https://github.com/Bonnivaldo/TouchAndTest/assets/53324114/c89310c1-2cba-4914-bb5e-f8b9e8b741df" alt="failed test" width="200"/></td>
    <td><img src="https://github.com/Bonnivaldo/TouchAndTest/assets/53324114/3f1fc1a0-e995-437a-8bcb-bd847c05afe3" alt="success state grid" width="200"/></td>
    <td><img src="https://github.com/Bonnivaldo/TouchAndTest/assets/53324114/af7d13fe-96e0-4881-92c9-6c507d76e1ef" alt="success test button" width="200"/></td>
  </tr>
</table>

### Libraries Used

- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Modern toolkit for building native Android UI.
- [Hilt](https://dagger.dev/hilt/) - Dependency injection library for Android.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Manages UI-related data in a lifecycle-conscious way.
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Lifecycle-aware observable data holder class.

### How to Run the Project

#### Prerequisites

- Android Studio 4.2 or higher
- JDK 1.8 or higher

#### Steps to Run

1. Clone this repository:
   ```sh
   git clone https://github.com/Bonnivaldo/TouchAndTest.git
   ```
2. Open the project in Android Studio.
3. Build the project and run it on an emulator or physical device.

### Contribution

If you want to contribute to this project, follow the steps below:

1. Fork the repository.
2. Create a branch for your feature (`git checkout -b feature/feature-name`).
3. Commit your changes (`git commit -m 'Add a new feature'`).
4. Push to the branch (`git push origin feature/feature-name`).
5. Open a Pull Request.

### License

Distributed under the MIT License. See `LICENSE` for more information.

### Contact

Cleidson Bononi - [cleidson.bononi@gmail.com](mailto:cleidson.bononi@gmail.com)

Link do Projeto: [https://github.com/Bonnivaldo/TouchAndTest](https://github.com/Bonnivaldo/TouchAndTest)

---

## <a name="português"></a>Português

Um aplicativo Android em Jetpack Compose que exibe uma grade de botões. Cada botão pode ser desabilitado ao ser clicado, e o estado da grade é gerenciado por um ViewModel. O aplicativo também possui uma contagem regressiva e mensagens de timeout.

### Visão Geral

Este projeto é um exemplo de uso de Jetpack Compose para criar uma interface de usuário responsiva que exibe uma grade de botões. Cada botão na grade pode ser clicado para ser desabilitado, e o estado é gerenciado por um ViewModel. O aplicativo inclui uma contagem regressiva e mensagens de feedback ao usuário.

### Funcionalidades

- Exibe uma grade de 36 botões dispostos em 9 linhas e 4 colunas.
- Cada botão pode ser clicado para ser desabilitado.
- O estado da grade é gerenciado usando LiveData no ViewModel.
- Contagem regressiva de 10 segundos para completar o teste.
- Exibe mensagens de sucesso ou falha com base no resultado do teste.
- Atualização dinâmica da interface de usuário baseada no estado observado.

### Capturas de Tela

<table>
  <tr>
    <td><img src="https://github.com/Bonnivaldo/TouchAndTest/assets/53324114/81aeccc0-5542-4f95-8310-8fad0f265615" alt="initial view" width="200"/></td>
    <td><img src="https://github.com/Bonnivaldo/TouchAndTest/assets/53324114/959c4bfe-4b25-479a-9d98-db008d8bbe69" alt="initial grid" width="200"/></td>
    <td><img src="https://github.com/Bonnivaldo/TouchAndTest/assets/53324114/c89310c1-2cba-4914-bb5e-f8b9e8b741df" alt="failed test" width="200"/></td>
    <td><img src="https://github.com/Bonnivaldo/TouchAndTest/assets/53324114/3f1fc1a0-e995-437a-8bcb-bd847c05afe3" alt="success state grid" width="200"/></td>
    <td><img src="https://github.com/Bonnivaldo/TouchAndTest/assets/53324114/3dc501cb-df92-44fc-9b1e-1743640dc7e7" alt="success test button" width="200"/></td>
  </tr>
</table>

### Bibliotecas Utilizadas

- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Toolkit moderno para construir interfaces nativas do Android.
- [Hilt](https://dagger.dev/hilt/) - Biblioteca para injeção de dependências no Android.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Gerencia o UI-related data de maneira cíclica consciente.
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Componente de dados observáveis que respeita o ciclo de vida.

### Como Executar o Projeto

#### Pré-requisitos

- Android Studio 4.2 ou superior
- JDK 1.8 ou superior

#### Passos para Execução

1. Clone este repositório:
   ```sh
   git clone https://github.com/Bonnivaldo/TouchAndTest.git
   ```
2. Abra o projeto no Android Studio.
3. Construa o projeto e execute no emulador ou em um dispositivo físico.

### Contribuição

Se você deseja contribuir com este projeto, siga as instruções abaixo:

1. Faça um fork do repositório.
2. Crie uma branch para sua feature (`git checkout -b feature/nome-da-feature`).
3. Commit suas alterações (`git commit -m 'Adiciona uma nova feature'`).
4. Push para a branch (`git push origin feature/nome-da-feature`).
5. Abra um Pull Request.

### Licença

Distribuído sob a licença MIT. Veja `LICENSE` para mais informações.

### Contato

Cleidson Bononi - [cleidson.bononi@gmail.com](mailto:cleidson.bononi@gmail.com)

Link do Projeto: [https://github.com/Bonnivaldo/TouchAndTest](https://github.com/Bonnivaldo/TouchAndTest)
