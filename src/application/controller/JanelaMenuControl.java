package application.controller;

import javax.swing.*;

/**
 * control --> events --> view
 * view = vizualização
 * events = eventos/ações dos objetos
 * control = classe para criação dos objetos interáveis
 * model = requisições
 **/

public class JanelaMenuControl extends JFrame {
    // Atributo dos objetos interáveis

    // Frame
    private JFrame frameMenu = new JFrame("Controle de Energia - Início");
    public JFrame getFrameMenu() {
        return frameMenu;
    }

    // MENU INICIO
    // Botão de Inicio
    private JButton btnInicio = new JButton("Inicio");
    public JButton getBtnInicio() {
        return btnInicio;
    }

    // icons do menu Inicio
    private JLabel iconInicio = new JLabel();
    public JLabel getIconInicio() {
        return iconInicio;
    }

    // Painel de Inicio
    private JPanel panelInicio = new JPanel();
    public JPanel getPanelInicio() {
        return panelInicio;
    }

    // MENU APARELHOS
    // Botão de Aparelhos
    private JButton btnAparelhos = new JButton("Aparelhos");
    public JButton getBtnAparelhos() {
        return btnAparelhos;
    }

    // icons do menu Aparelhos
    private JLabel iconAparelhos = new JLabel();
    public JLabel getIconAparelhos() {
        return iconAparelhos;
    }

    // Painel de Aparelhos
    private JPanel panelAparelhos = new JPanel();
    public JPanel getPanelAparelhos() {
        return panelAparelhos;
    }

    // Fields para o cadastro de aparelho
    private JTextField fieldNomeAparelho = new JTextField();
    private JTextField fieldNomeFabricante = new JTextField();
    private JTextField fieldMarca = new JTextField();
    private JTextField fieldModelo = new JTextField();
    private JTextField fieldVolts = new JTextField();
    private JTextField fieldWatts = new JTextField();
    private JTextField fieldTempo = new JTextField();
    private JButton btnCadastrarAparelho = new JButton("Cadastrar");
    private JTable tabelaAparelho = new JTable();
    private JButton btnExcluirAparelho = new JButton("Excluir Aparelho");
    private JButton btnCustoMensal = new JButton("Custo Mensal");

    public JTextField getFieldNomeAparelho() {
        return fieldNomeAparelho;
    }
    public JTextField getFieldNomeFabricante() {
        return fieldNomeFabricante;
    }
    public JTextField getFieldMarca() {
        return fieldMarca;
    }
    public JTextField getFieldModelo() {
        return fieldModelo;
    }
    public JTextField getFieldVolts() {
        return fieldVolts;
    }
    public JTextField getFieldWatts() {
        return fieldWatts;
    }
    public JTextField getFieldTempo() {
        return fieldTempo;
    }
    public JButton getBtnCadastrarAparelho() {
        return btnCadastrarAparelho;
    }
    public JTable getTabelaAparelho() {
        return tabelaAparelho;
    }
    public JButton getBtnExcluirAparelho() {
        return btnExcluirAparelho;
    }
    public JButton getBtnCustoMensal() {
        return btnCustoMensal;
    }

    // MENU COMPANHIA
    // Botão de Companhia
    private JButton btnCompanhia = new JButton("Companhia");
    public JButton getBtnCompanhia() {
        return btnCompanhia;
    }

    // icons do menu Companhia
    private JLabel iconCompanhia = new JLabel();
    public JLabel getIconCompanhia() {
        return iconCompanhia;
    }

    // Painel de Companhia
    private JPanel panelCompanhia = new JPanel();
    public JPanel getPanelCompanhia() {
        return panelCompanhia;
    }

    // Fields para o cadastro da companhia
    private JTextField fieldNomeCompanhia = new JTextField();
    private JTextField fieldCnpjCompanhia = new JTextField();
    private JTextField fieldTelefoneCompanhia = new JTextField();
    private JCheckBox checkGrupoA = new JCheckBox("Grupo A");
    private JCheckBox checkGrupoB = new JCheckBox("Grupo B");
    private JRadioButton mediaTensao = new JRadioButton("Média Tensão");
    private JRadioButton altaTensao = new JRadioButton("Alta Tensão");
    private JRadioButton residencial = new JRadioButton("Residencial");
    private JRadioButton rural = new JRadioButton("Rural");
    private JRadioButton outros = new JRadioButton("Outros");
    private JComboBox<String> comboTipoFornecimento = new JComboBox<>();
    private JTextField fieldNumMedidor = new JTextField();
    private JTextField fieldTarifa = new JTextField();
    private JTextArea infoTarifa = new JTextArea();
    private JButton cadastrarCompanhia = new JButton("Cadastrar");
    private ButtonGroup subGrupo = new ButtonGroup();
    private JTable tabelaCompanhia = new JTable();
    private JButton btnExcluirCompanhia = new JButton("Excluir Companhia");

    public JTextField getFieldNomeCompanhia() {
        return fieldNomeCompanhia;
    }
    public JTextField getFieldCnpjCompanhia() {
        return fieldCnpjCompanhia;
    }
    public JTextField getFieldTelefoneCompanhia() {
        return fieldTelefoneCompanhia;
    }
    public JCheckBox getCheckGrupoA() {
        return checkGrupoA;
    }
    public JCheckBox getCheckGrupoB() {
        return checkGrupoB;
    }
    public JRadioButton getMediaTensao() {
        return mediaTensao;
    }
    public JRadioButton getAltaTensao() {
        return altaTensao;
    }
    public JRadioButton getResidencial() {
        return residencial;
    }
    public JRadioButton getRural() {
        return rural;
    }
    public JRadioButton getOutros() {
        return outros;
    }
    public JComboBox getComboTipoFornecimento() {
        return comboTipoFornecimento;
    }
    public JTextField getFieldNumMedidor() {
        return fieldNumMedidor;
    }
    public JTextField getFieldTarifa() {
        return fieldTarifa;
    }
    public JTextArea getInfoTarifa() {
        return infoTarifa;
    }
    public JButton getCadastrarCompanhia() {
        return cadastrarCompanhia;
    }
    public ButtonGroup getSubGrupo() {
        return subGrupo;
    }
    public JTable getTabelaCompanhia() {
        return tabelaCompanhia;
    }
    public JButton getBtnExcluirCompanhia() {
        return btnExcluirCompanhia;
    }

    // MENU CADASTRO
    // Botão de Cadastro
    private JButton btnCadastro = new JButton("Cadastro");
    public JButton getBtnCadastro() {
        return btnCadastro;
    }

    // icons do menu Cadastro
    private JLabel iconCadastro = new JLabel();
    public JLabel getIconCadastro() {
        return iconCadastro;
    }

    // Painel de Cadastro
    private  JPanel panelCadastro = new JPanel();
    public JPanel getPanelCadastro() {
        return panelCadastro;
    }

    // Labels que recebe os dados do usuario do banco de dados atualizados
    private JLabel nomebd = new JLabel();
    private JLabel sobrenomebd = new JLabel();
    private JLabel telefonebd = new JLabel();
    private JLabel emailbd = new JLabel();
    public  JLabel getNomebd(){
        return nomebd;
    }
    public JLabel getSobrenomebd() {
        return sobrenomebd;
    }
    public JLabel getTelefonebd() {
        return telefonebd;
    }
    public JLabel getEmailbd() {
        return emailbd;
    }

    // Fields para alterar os dados do usuario
    private JTextField fieldNovoNome = new JTextField();
    private JTextField fieldNovoSobrenome = new JTextField();
    private JTextField fieldNovotelefone = new JTextField();
    private JTextField fieldNovoEmail = new JTextField();
    public JTextField getFieldNovoNome() {
        return fieldNovoNome;
    }
    public JTextField getFieldNovoSobrenome() {
        return fieldNovoSobrenome;
    }
    public JTextField getFieldNovoTelefone() {
        return fieldNovotelefone;
    }
    public JTextField getFieldNovoEmail() {
        return fieldNovoEmail;
    }

    // Botão para alterar dados do usuario
    private JButton btnAlterarDados = new JButton("Alterar");
    public JButton getBtnAlterarDados() {
        return btnAlterarDados;
    }

    // Fields para alterar o login e senha do usuario
    private JTextField fieldNovoLogin = new JTextField();
    private JPasswordField fielNovaSenha = new JPasswordField();
    public JTextField getFieldNovoLogin() {
        return fieldNovoLogin;
    }
    public  JPasswordField getFielNovaSenha() {
        return fielNovaSenha;
    }

    // Botão para alterar login do usuario
    private JButton btnAlterarLoginSenha = new JButton("Alterar");
    public JButton getBtnAlterarLoginSenha() {
        return btnAlterarLoginSenha;
    }

    // Botão para excluir usuario
    private JButton btnExcluirUsuario = new JButton("Excluir Conta");
    public JButton getBtnExcluirUsuario() {
        return btnExcluirUsuario;
    }

    // Labels que recebe os dados do usuario do banco de dados atualizados
    private JLabel cepbd = new JLabel();
    private JLabel ruabd = new JLabel();
    private JLabel numerobd = new JLabel();
    private JLabel bairrobd = new JLabel();
    private JLabel cidadebd = new JLabel();
    private JLabel estadobd = new JLabel();
    public JLabel getCepbd() {
        return cepbd;
    }
    public JLabel getRuabd() {
        return ruabd;
    }
    public JLabel getNumerobd() {
        return numerobd;
    }
    public JLabel getBairrobd() {
        return bairrobd;
    }
    public JLabel getCidadebd() {
        return cidadebd;
    }
    public JLabel getEstadobd() {
        return estadobd;
    }

    // Fields para alterar o endereço do usuario
    private JTextField fieldCEP = new JTextField();
    private JTextField fieldRua = new JTextField();
    private JTextField fieldNumero = new JTextField();
    private JTextField fieldBairro = new JTextField();
    private JTextField fieldCidade = new JTextField();
    private JTextField fieldEstado = new JTextField();
    public JTextField getFieldCEP() {
        return fieldCEP;
    }
    public JTextField getFieldRua() {
        return fieldRua;
    }
    public JTextField getFieldNumero() {
        return fieldNumero;
    }
    public JTextField getFieldBairro() {
        return fieldBairro;
    }
    public JTextField getFieldCidade() {
        return fieldCidade;
    }
    public JTextField getFieldEstado() {
        return fieldEstado;
    }

    // Botão para alterar endereço do usuario
    private JButton btnAlterarEndereco = new JButton("Alterar");
    public JButton getBtnAlterarEndereco() {
        return btnAlterarEndereco;
    }

    // MENU AJUDA
    // Botão de Ajuda
    private JButton btnAjuda = new JButton("Ajuda");
    public JButton getBtnAjuda() {
        return btnAjuda;
    }

    // icons do menu Ajuda
    private JLabel iconAjuda = new JLabel();
    public JLabel getIconAjuda() {
        return iconAjuda;
    }

    // Painel de Ajuda
    private JPanel panelAjuda = new JPanel();
    public JPanel getPanelAjuda() {
        return panelAjuda;
    }

    // Botões do Sair
    private JButton btnSair = new JButton("Sair");
    public JButton getBtnSair() {
        return btnSair;
    }

    // Atributos de login do usuario
    private JLabel logado = new JLabel();
    public JLabel getLogado() {
        return logado;
    }
}