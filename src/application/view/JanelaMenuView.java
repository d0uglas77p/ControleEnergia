package application.view;

import application.Main;
import application.events.JanelaMenuEvents;
import application.model.DAO.CompanhiaDAO;
import application.model.DAO.EnderecoDAO;
import application.model.entity.Companhia;
import application.model.entity.Endereco;
import application.model.entity.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

// Classe front da Janela de Menu
public class JanelaMenuView extends JanelaMenuEvents {

    private EnderecoDAO enderecoDAO;
    private CompanhiaDAO companhiaDAO;

    public JanelaMenuView(Usuario usuario) throws SQLException {
        this.enderecoDAO = new EnderecoDAO();
        this.companhiaDAO = new CompanhiaDAO();

        // Instanciando o frameMenu
        getFrameMenu().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrameMenu().setSize(1000,600);
        getFrameMenu().setResizable(false);
        getFrameMenu().setLocationRelativeTo(null);

        // MENU
        // --------------------------------------------------------------------------------------------------------- //
        // Painel de Menu, onde fica as opções do menu
        JPanel panelMenu = new JPanel();
        panelMenu.setSize(260,600);
        Color transparentBlack = new Color(0,0,0, 255);
        panelMenu.setBackground(transparentBlack);
        getFrameMenu().add(panelMenu);
        panelMenu.setLayout(null);

        // Texto Controle de Energia
        JLabel txtControleEnergia = new JLabel("Controle de Energia");
        txtControleEnergia.setBounds(45,20,200,20);
        txtControleEnergia.setFont(new Font("Arial",Font.BOLD,18));
        txtControleEnergia.setForeground(Color.WHITE);
        panelMenu.add(txtControleEnergia);

        // Icones das opções de menu
        ImageIcon iconInicio = new ImageIcon(Main.class.getResource("/application/view/icons/inicio.png"));
        getIconInicio().setIcon(iconInicio);
        getIconInicio().setBounds(75,65,150,150);
        getIconInicio().setVisible(true);
        panelMenu.add(getIconInicio());

        ImageIcon iconAparelho = new ImageIcon(Main.class.getResource("/application/view/icons/aparelhos.png"));
        getIconAparelhos().setIcon(iconAparelho);
        getIconAparelhos().setBounds(75,65,150,150);
        getIconAparelhos().setVisible(false);
        panelMenu.add(getIconAparelhos());

        ImageIcon iconCompanhia = new ImageIcon(Main.class.getResource("/application/view/icons/companhia.png"));
        getIconCompanhia().setIcon(iconCompanhia);
        getIconCompanhia().setBounds(75,65,150,150);
        getIconCompanhia().setVisible(false);
        panelMenu.add(getIconCompanhia());

        ImageIcon iconCadastro = new ImageIcon(Main.class.getResource("/application/view/icons/cadastro.png"));
        getIconCadastro().setIcon(iconCadastro);
        getIconCadastro().setBounds(75,65,150,150);
        getIconCadastro().setVisible(false);
        panelMenu.add(getIconCadastro());

        ImageIcon iconAjuda = new ImageIcon(Main.class.getResource("/application/view/icons/ajuda.png"));
        getIconAjuda().setIcon(iconAjuda);
        getIconAjuda().setBounds(75,65,150,150);
        getIconAjuda().setVisible(false);
        panelMenu.add(getIconAjuda());

        // label txt usuario
        JLabel labelUsuariotxt = new JLabel("Usuário:");
        labelUsuariotxt.setBounds(10,535,200,20);
        labelUsuariotxt.setFont(new Font("Calibri", Font.PLAIN,12));
        Color colorLogado = new Color(0, 255, 247, 255);
        labelUsuariotxt.setForeground(colorLogado);
        panelMenu.add(labelUsuariotxt);

        // Nome do usuario logado no painel de menu opções, canto inferior esquerdo
        getLogado().setText(usuario.getUsuario());
        getLogado().setBounds(60,535,200,20);
        getLogado().setFont(new Font("Calibri",Font.PLAIN,12));
        getLogado().setForeground(colorLogado);
        panelMenu.add(getLogado());

        // Botão de Inicio
        getBtnInicio().setBounds(-10,260,280,40);
        getBtnInicio().setForeground(Color.WHITE);
        getBtnInicio().setFont(new Font("Arial",Font.BOLD,14));
        // Configuração da borda do botão
        getBtnInicio().setFocusPainted(false);
        getBtnInicio().setBorderPainted(false);
        getBtnInicio().setBackground(transparentBlack);
        panelMenu.add(getBtnInicio());

        // Botão de aparelhos
        getBtnAparelhos().setBounds(-10,299,280,40);
        getBtnAparelhos().setForeground(Color.WHITE);
        getBtnAparelhos().setFont(new Font("Arial",Font.BOLD,14));
        // Configuração da borda do botão
        getBtnAparelhos().setFocusPainted(false);
        getBtnAparelhos().setBorderPainted(false);
        getBtnAparelhos().setBackground(transparentBlack);
        panelMenu.add(getBtnAparelhos());

        // Botão de companhia
        getBtnCompanhia().setBounds(-10,338,280,40);
        getBtnCompanhia().setForeground(Color.WHITE);
        getBtnCompanhia().setFont(new Font("Arial",Font.BOLD,14));
        // Configuração da borda do botão
        getBtnCompanhia().setFocusPainted(false);
        getBtnCompanhia().setBorderPainted(false);
        getBtnCompanhia().setBackground(transparentBlack);
        panelMenu.add(getBtnCompanhia());

        // Botão de cadastro
        getBtnCadastro().setBounds(-10,377,280,40);
        getBtnCadastro().setForeground(Color.WHITE);
        getBtnCadastro().setFont(new Font("Arial",Font.BOLD,14));
        // Configuração da borda do botão
        getBtnCadastro().setFocusPainted(false);
        getBtnCadastro().setBorderPainted(false);
        getBtnCadastro().setBackground(transparentBlack);
        panelMenu.add(getBtnCadastro());

        // Botão de ajuda
        getBtnAjuda().setBounds(-10,416,280,40);
        getBtnAjuda().setForeground(Color.WHITE);
        getBtnAjuda().setFont(new Font("Arial",Font.BOLD,14));
        // Configuração da borda do botão
        getBtnAjuda().setFocusPainted(false);
        getBtnAjuda().setBorderPainted(false);
        getBtnAjuda().setBackground(transparentBlack);
        panelMenu.add(getBtnAjuda());

        // Botão de sair
        getBtnSair().setBounds(-10,455,280,40);
        getBtnSair().setForeground(Color.WHITE);
        getBtnSair().setFont(new Font("Arial",Font.BOLD,14));
        // Configuração da borda do botão
        getBtnSair().setFocusPainted(false);
        getBtnSair().setBorderPainted(false);
        getBtnSair().setBackground(transparentBlack);
        panelMenu.add(getBtnSair());
        // -------------------------------------------FIM MENU------------------------------------------------------- //


        // TELAS DAS OPÇÕES DE MENU
        // --------------------------------------------------------------------------------------------------------- //
        // - TELA DE INICIO DA OPÇÃO DE MENU INICIO -
        getPanelInicio().setBounds(280,0,705,562);
        getPanelInicio().setLayout(null);
        getFrameMenu().add(getPanelInicio());
        //texto
        JLabel txtInicio = new JLabel("INICIO");
        txtInicio.setBounds(300,20,100,20);
        txtInicio.setFont(new Font("Arial",Font.BOLD,18));
        txtInicio.setForeground(Color.BLACK);
        getPanelInicio().add(txtInicio);
        // -------------------------------------------FIM INICIO---------------------------------------------------- //


        // --------------------------------------------------------------------------------------------------------- //
        // - TELA DE APARELHOS DA OPÇÃO DE MENU APARELHOS -
        getPanelAparelhos().setBounds(280,0,705,562);
        getPanelAparelhos().setLayout(null);
        getFrameMenu().add(getPanelAparelhos());
        //texto
        JLabel txtAparelhos = new JLabel("APARELHOS");
        txtAparelhos.setBounds(300,20,200,20);
        txtAparelhos.setFont(new Font("Arial",Font.BOLD,18));
        txtAparelhos.setForeground(Color.BLACK);
        getPanelAparelhos().add(txtAparelhos);
        // -------------------------------------------FIM APARELHOS------------------------------------------------- //


        // --------------------------------------------------------------------------------------------------------- //
        // - TELA DE COMPANHIA DA OPÇÃO DE MENU COMPANHIA -
        getPanelCompanhia().setBounds(280,0,705,562);
        getPanelCompanhia().setLayout(null);
        getFrameMenu().add(getPanelCompanhia());

        // Labels da tela de companhia
        JLabel nomeCompanhiatxt = new JLabel("Nome da Companhia Elétrica");
        nomeCompanhiatxt.setBounds(20,25,300,20);
        nomeCompanhiatxt.setFont(new Font("Arial", Font.BOLD, 14));
        nomeCompanhiatxt.setForeground(Color.BLACK);
        getPanelCompanhia().add(nomeCompanhiatxt);

        JLabel cnpjCompanhiatxt = new JLabel("CNPJ");
        cnpjCompanhiatxt.setBounds(20,70,300,20);
        cnpjCompanhiatxt.setFont(new Font("Arial", Font.BOLD, 14));
        cnpjCompanhiatxt.setForeground(Color.BLACK);
        getPanelCompanhia().add(cnpjCompanhiatxt);

        JLabel telefoneCompanhiatxt = new JLabel("Telefone");
        telefoneCompanhiatxt.setBounds(20,115,300,20);
        telefoneCompanhiatxt.setFont(new Font("Arial", Font.BOLD, 14));
        telefoneCompanhiatxt.setForeground(Color.BLACK);
        getPanelCompanhia().add(telefoneCompanhiatxt);

        // Fields da tela de cadastro
        getFieldNomeCompanhia().setVisible(false);
        getFieldNomeCompanhia().setBounds(20,45,310,26);
        getPanelCompanhia().add(getFieldNomeCompanhia());

        getFieldCnpjCompanhia().setVisible(false);
        getFieldCnpjCompanhia().setBounds(20,90,310,26);
        getPanelCompanhia().add(getFieldCnpjCompanhia());

        getFieldTelefoneCompanhia().setVisible(false);
        getFieldTelefoneCompanhia().setBounds(20,135,310,26);
        getPanelCompanhia().add(getFieldTelefoneCompanhia());

        // Classificação da modalidade tarifaria
        getCheckGrupoA().setVisible(false);
        getCheckGrupoA().setBounds(95,200,70,20);
        getCheckGrupoA().setFont(new Font("Arial",Font.BOLD,12));
        getPanelCompanhia().add(getCheckGrupoA());

        getCheckGrupoB().setVisible(false);
        getCheckGrupoB().setBounds(175,200,70,20);
        getCheckGrupoB().setFont(new Font("Arial",Font.BOLD,12));
        getPanelCompanhia().add(getCheckGrupoB());

        // Agrupando grupo da classificação
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(getCheckGrupoA());
        grupo.add(getCheckGrupoB());

        getMediaTensao().setVisible(false);
        getMediaTensao().setBounds(70,235,100,20);
        getPanelCompanhia().add(getMediaTensao());

        getAltaTensao().setVisible(false);
        getAltaTensao().setBounds(195,235,100,20);
        getPanelCompanhia().add(getAltaTensao());

        getResidencial().setVisible(false);
        getResidencial().setBounds(45,235,90,20);
        getPanelCompanhia().add(getResidencial());

        getRural().setVisible(false);
        getRural().setBounds(159,235,55,20);
        getPanelCompanhia().add(getRural());

        getOutros().setVisible(false);
        getOutros().setBounds(235,235,60,20);
        getPanelCompanhia().add(getOutros());

        // Agrupando subgrupo do grupo de classificação
        getSubGrupo().add(getMediaTensao());
        getSubGrupo().add(getAltaTensao());
        getSubGrupo().add(getResidencial());
        getSubGrupo().add(getRural());
        getSubGrupo().add(getOutros());

        // Label do tipo de fornecimento
        JLabel tipoFornecimentotxt = new JLabel("Tipo de Fornecimento");
        tipoFornecimentotxt.setBounds(35,275,300,20);
        tipoFornecimentotxt.setFont(new Font("Arial", Font.BOLD, 14));
        tipoFornecimentotxt.setForeground(Color.BLACK);
        getPanelCompanhia().add(tipoFornecimentotxt);

        // Adicionando combo box do tipo de fornecimento
        getComboTipoFornecimento().setVisible(false);
        getComboTipoFornecimento().setBounds(190,273,125,25);
        getPanelCompanhia().add(getComboTipoFornecimento());

        getComboTipoFornecimento().addItem("Monofásico");
        getComboTipoFornecimento().addItem("Bifásico");
        getComboTipoFornecimento().addItem("Trifásico");

        // Label do numero do medidor
        JLabel numMedidortxt = new JLabel("N° do Medidor");
        numMedidortxt.setBounds(35,320,300,20);
        numMedidortxt.setFont(new Font("Arial", Font.BOLD, 14));
        numMedidortxt.setForeground(Color.BLACK);
        getPanelCompanhia().add(numMedidortxt);

        // Adicionando field do numero do medidor
        getFieldNumMedidor().setVisible(false);
        getFieldNumMedidor().setBounds(140,318,175,26);
        getPanelCompanhia().add(getFieldNumMedidor());


        // Painel de classificação da instalação de energia
        JPanel panelClassificacao = new JPanel();
        panelClassificacao.setBorder(BorderFactory.createTitledBorder("CLASSIFICAÇÃO")); // Borda personalizada do painel
        panelClassificacao.setBounds(20,175,309,200); // Posição e tamanho do painel
        getPanelCompanhia().add(panelClassificacao);

        // Labels da tarifa da companhia
        JLabel tarifaTxt = new JLabel("Tarifa de Energia");
        tarifaTxt.setBounds(370,54,300,20);
        tarifaTxt.setFont(new Font("Arial", Font.BOLD, 14));
        tarifaTxt.setForeground(Color.BLACK);
        getPanelCompanhia().add(tarifaTxt);

        // Field da tarifa da companhia
        getFieldTarifa().setVisible(false);
        getFieldTarifa().setBounds(500,52,140,26);
        getPanelCompanhia().add(getFieldTarifa());

        // Menssagem de atenção da tarifa da companhia
        String info = "  Atenção usuário, o valor da tarifa refere-se à\n" +
                " quantia financeira cobrada pela prestação do\n" +
                " serviço de energia elétrica. Verifique os\n" +
                " encargos/impostos cobrados em sua conta de\n" +
                " luz e certifique-se de trazer o valor total da tarifa\n" +
                " cobrada mensalmente da sua distribuidora.\n" +
                "\n  É importante destacar que as tarifas de energia\n" +
                " variam conforme a distribuidora e a região.\n" +
                " Cada localidade possui características\n" +
                " específicas que impactam diretamente nos\n" +
                " custos do serviço.\n" +
                "\n   Consulte os detalhes junto a sua companhia\n" +
                " de distribuição elétrica.";

        // Adiocionando mensagem no TextArea
        getInfoTarifa().setVisible(false);
        getInfoTarifa().setBounds(370,85,270,247);
        getInfoTarifa().setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 153)));
        Color transparent = new Color(255, 255, 255, 203); // Cor
        getInfoTarifa().setBackground(transparent);
        getInfoTarifa().setEditable(false);
        getInfoTarifa().setLineWrap(true);
        getInfoTarifa().setWrapStyleWord(true);
        getInfoTarifa().setFocusable(false);
        getInfoTarifa().setText(info);
        getPanelCompanhia().add(getInfoTarifa());

        // Botão de cadastro da companhia
        getCadastrarCompanhia().setVisible(false);
        getCadastrarCompanhia().setBounds(450,350,90,26);
        getCadastrarCompanhia().setFont(new Font("Arial",Font.BOLD,12));
        getPanelCompanhia().add(getCadastrarCompanhia());

        // Painel de encargos da companhia
        JPanel panelEncargo = new JPanel();
        panelEncargo.setBorder(BorderFactory.createTitledBorder("ENCARGOS"));
        panelEncargo.setBounds(350,25,309,325);
        getPanelCompanhia().add(panelEncargo);

        // lista de companhias cadastradas
        List<Companhia> companhiasUsuario = companhiaDAO.buscarCompanhias(usuario.getId());

        // Nome das colunas
        String[] header = {"Nome", "CNPJ", "Telefone", "Fornecimento", "Medidor", "Tarifa"};

        String[][] data = new String[companhiasUsuario.size()][header.length];

            if (!companhiasUsuario.isEmpty()) {
                for (int i = 0; i < companhiasUsuario.size(); i++) {
                    Companhia companhia = companhiasUsuario.get(i);
                    data[i] = new String[]{
                            companhia.getNomeCompanhia(),
                            companhia.getCnpj(),
                            companhia.getTelefoneCompanhia(),
                            companhia.getTipoFornecimento(),
                            companhia.getMedidor(),
                            companhia.getTarifa(),
                    };
                }
            } else {
                data = new String[0][header.length];
            }

        // Modelo da tabela
        DefaultTableModel model = new DefaultTableModel(data, header);
        getTabelaCompanhia().setModel(model);

        // Criar a tabela
        getPanelCompanhia().setVisible(false);
        JScrollPane scrollPane = new JScrollPane(getTabelaCompanhia());
        scrollPane.setBounds(25,400,630,100);
        getPanelCompanhia().add(scrollPane);

        // Excluir companhia cadastrada
        getBtnExcluirCompanhia().setVisible(false);
        getBtnExcluirCompanhia().setBounds(270,515,150,26);
        getBtnExcluirCompanhia().setFont(new Font("Arial", Font.BOLD,12));
        getPanelCompanhia().add(getBtnExcluirCompanhia());

        // -------------------------------------------FIM COMPANHIA------------------------------------------------- //


        // --------------------------------------------------------------------------------------------------------- //
        // - TELA DE CADASTRO DA OPÇÃO DE MENU CADASTRO -
        getPanelCadastro().setBounds(280,0,705,562);
        getPanelCadastro().setLayout(null);
        getFrameMenu().add(getPanelCadastro());

        // ELEMENTOS DA TABELA DO PAINEL DE CADASTRO
        // Labels da tabela de dados atuais
        JLabel nometxt = new JLabel("Nome:");
        nometxt.setBounds(36,50,100,20);
        nometxt.setFont(new Font("Arial",Font.BOLD,14));
        nometxt.setForeground(Color.BLACK);
        getPanelCadastro().add(nometxt);

        JLabel sobrenometxt = new JLabel("Sobrenome:");
        sobrenometxt.setBounds(36,75,100,20);
        sobrenometxt.setFont(new Font("Arial",Font.BOLD,14));
        sobrenometxt.setForeground(Color.BLACK);
        getPanelCadastro().add(sobrenometxt);

        JLabel telefonetxt = new JLabel("Telefone:");
        telefonetxt.setBounds(36,99,100,20);
        telefonetxt.setFont(new Font("Arial",Font.BOLD,14));
        telefonetxt.setForeground(Color.BLACK);
        getPanelCadastro().add(telefonetxt);

        JLabel emailtxt = new JLabel("Email:");
        emailtxt.setBounds(36,125,100,20);
        emailtxt.setFont(new Font("Arial",Font.BOLD,14));
        emailtxt.setForeground(Color.BLACK);
        getPanelCadastro().add(emailtxt);

        JLabel dtnascimentotxt = new JLabel("Data de Nascimento:");
        dtnascimentotxt.setBounds(36,150,160,20);
        dtnascimentotxt.setFont(new Font("Arial",Font.BOLD,14));
        dtnascimentotxt.setForeground(Color.BLACK);
        getPanelCadastro().add(dtnascimentotxt);

        // Labels que pega os dados do usuario da tabela de dados atuais
        getNomebd().setText(usuario.getNome());
        getNomebd().setBounds(87,53,200,20);
        getNomebd().setFont(new Font("Calibri",Font.PLAIN,16));
        getPanelCadastro().add(getNomebd());

        getSobrenomebd().setText(usuario.getSobrenome());
        getSobrenomebd().setBounds(130,78,200,20);
        getSobrenomebd().setFont(new Font("Calibri",Font.PLAIN,16));
        getPanelCadastro().add(getSobrenomebd());

        getTelefonebd().setText(usuario.getTelefone());
        getTelefonebd().setBounds(107,102,200,20);
        getTelefonebd().setFont(new Font("Calibri",Font.PLAIN,16));
        getPanelCadastro().add(getTelefonebd());

        getEmailbd().setText(usuario.getEmail());
        getEmailbd().setBounds(85,128,300,20);
        getEmailbd().setFont(new Font("Calibri",Font.PLAIN,16));
        getPanelCadastro().add(getEmailbd());

        JLabel dtnascimentobd = new JLabel();
        dtnascimentobd.setText(usuario.getDtNascimento());
        dtnascimentobd.setBounds(185,154,200,20);
        dtnascimentobd.setFont(new Font("Calibri",Font.PLAIN,16));
        getPanelCadastro().add(dtnascimentobd);

        // Labels da tabela inferior de alterar dados
        JLabel nometxt2 = new JLabel("Nome");
        nometxt2.setBounds(36,185,100,20);
        nometxt2.setFont(new Font("Arial",Font.BOLD,14));
        nometxt2.setForeground(Color.BLACK);
        getPanelCadastro().add(nometxt2);

        JLabel sobrenometxt2 = new JLabel("Sobrenome");
        sobrenometxt2.setBounds(36,230,100,20);
        sobrenometxt2.setFont(new Font("Arial",Font.BOLD,14));
        sobrenometxt2.setForeground(Color.BLACK);
        getPanelCadastro().add(sobrenometxt2);

        JLabel telefonetxt2 = new JLabel("Telefone");
        telefonetxt2.setBounds(36,275,100,20);
        telefonetxt2.setFont(new Font("Arial",Font.BOLD,14));
        telefonetxt2.setForeground(Color.BLACK);
        getPanelCadastro().add(telefonetxt2);


        JLabel emailtxt2 = new JLabel("Email");
        emailtxt2.setBounds(36,325,100,20);
        emailtxt2.setFont(new Font("Arial",Font.BOLD,14));
        emailtxt2.setForeground(Color.BLACK);
        getPanelCadastro().add(emailtxt2);


        // Fields da tabela inferior de alterar dados
        getFieldNovoNome().setVisible(false);
        getFieldNovoNome().setBounds(36,205,276,26);
        getPanelCadastro().add(getFieldNovoNome());

        getFieldNovoSobrenome().setVisible(false);
        getFieldNovoSobrenome().setBounds(36,250,276,26);
        getPanelCadastro().add(getFieldNovoSobrenome());

        getFieldNovoTelefone().setVisible(false);
        getFieldNovoTelefone().setBounds(36,299,276,26);
        getPanelCadastro().add(getFieldNovoTelefone());

        getFieldNovoEmail().setVisible(false);
        getFieldNovoEmail().setBounds(36,348,276,26);
        getPanelCadastro().add(getFieldNovoEmail());

        // Botão de alterar dados do usuario
        getBtnAlterarDados().setVisible(false);
        getBtnAlterarDados().setBounds(140, 380, 70, 25);
        getPanelCadastro().add(getBtnAlterarDados());

        // Labels da tabela de login
        JLabel logintxt = new JLabel("Login:");
        logintxt.setBounds(36,455,100,20);
        logintxt.setFont(new Font("Arial",Font.BOLD,14));
        logintxt.setForeground(Color.BLACK);
        getPanelCadastro().add(logintxt);

        JLabel senhatxt = new JLabel("Senha:");
        senhatxt.setBounds(34,489,100,20);
        senhatxt.setFont(new Font("Arial",Font.BOLD,14));
        senhatxt.setForeground(Color.BLACK);
        getPanelCadastro().add(senhatxt);

        // Fields da tabela de login
        getFieldNovoLogin().setVisible(false);
        getFieldNovoLogin().setBounds(87,452,225,26);
        getPanelCadastro().add(getFieldNovoLogin());

        getFielNovaSenha().setVisible(false);
        getFielNovaSenha().setBounds(87,488,225,26);
        getPanelCadastro().add(getFielNovaSenha());

        // Botão de excluir usuario
        getBtnExcluirUsuario().setVisible(false);
        getBtnExcluirUsuario().setBounds(125, 522, 110, 25);
        getPanelCadastro().add(getBtnExcluirUsuario());

        // Labels da tabela de endereço atual
        JLabel ceptxt = new JLabel("CEP:");
        ceptxt.setBounds(385,50,100,20);
        ceptxt.setFont(new Font("Arial",Font.BOLD,14));
        ceptxt.setForeground(Color.BLACK);
        getPanelCadastro().add(ceptxt);

        JLabel ruatxt = new JLabel("Rua:");
        ruatxt.setBounds(385,75,100,20);
        ruatxt.setFont(new Font("Arial",Font.BOLD,14));
        ruatxt.setForeground(Color.BLACK);
        getPanelCadastro().add(ruatxt);

        JLabel numerotxt = new JLabel("Número:");
        numerotxt.setBounds(385,99,100,20);
        numerotxt.setFont(new Font("Arial",Font.BOLD,14));
        numerotxt.setForeground(Color.BLACK);
        getPanelCadastro().add(numerotxt);

        JLabel bairrotxt = new JLabel("Bairro:");
        bairrotxt.setBounds(385,125,100,20);
        bairrotxt.setFont(new Font("Arial",Font.BOLD,14));
        bairrotxt.setForeground(Color.BLACK);
        getPanelCadastro().add(bairrotxt);

        JLabel cidadetxt = new JLabel("Cidade:");
        cidadetxt.setBounds(385,150,100,20);
        cidadetxt.setFont(new Font("Arial",Font.BOLD,14));
        cidadetxt.setForeground(Color.BLACK);
        getPanelCadastro().add(cidadetxt);

        JLabel estadotxt = new JLabel("Estado:");
        estadotxt.setBounds(385,175,100,20);
        estadotxt.setFont(new Font("Arial",Font.BOLD,14));
        estadotxt.setForeground(Color.BLACK);
        getPanelCadastro().add(estadotxt);

        // Labels que pega o endereço do usuario da tabela de endereço atual
        Endereco enderecoUsuario = enderecoDAO.buscarEndereco(usuario.getId());

        if (enderecoUsuario != null) {
            getCepbd().setText(enderecoUsuario.getCep());
            getCepbd().setBounds(425,53,200,20);
            getCepbd().setFont(new Font("Calibri",Font.PLAIN,16));
            getPanelCadastro().add(getCepbd());

            getRuabd().setText(enderecoUsuario.getRua());
            getRuabd().setBounds(425,78,200,20);
            getRuabd().setFont(new Font("Calibri",Font.PLAIN,16));
            getPanelCadastro().add(getRuabd());

            getNumerobd().setText(enderecoUsuario.getNumero());
            getNumerobd().setBounds(450,102,200,20);
            getNumerobd().setFont(new Font("Calibri",Font.PLAIN,16));
            getPanelCadastro().add(getNumerobd());

            getBairrobd().setText(enderecoUsuario.getBairro());
            getBairrobd().setBounds(440,128,200,20);
            getBairrobd().setFont(new Font("Calibri",Font.PLAIN,16));
            getPanelCadastro().add(getBairrobd());

            getCidadebd().setText(enderecoUsuario.getCidade());
            getCidadebd().setBounds(445,153,200,20);
            getCidadebd().setFont(new Font("Calibri",Font.PLAIN,16));
            getPanelCadastro().add(getCidadebd());

            getEstadobd().setText(enderecoUsuario.getEstado());
            getEstadobd().setBounds(445,178,200,20);
            getEstadobd().setFont(new Font("Calibri",Font.PLAIN,16));
            getPanelCadastro().add(getEstadobd());
        } else {
        }

        // Labels da tabela inferior de alterar endereço
        JLabel ceptxt2 = new JLabel("CEP");
        ceptxt2.setBounds(385,230,100,20);
        ceptxt2.setFont(new Font("Arial",Font.BOLD,14));
        ceptxt2.setForeground(Color.BLACK);
        getPanelCadastro().add(ceptxt2);

        JLabel ruatxt2 = new JLabel("Rua");
        ruatxt2.setBounds(385,275,100,20);
        ruatxt2.setFont(new Font("Arial",Font.BOLD,14));
        ruatxt2.setForeground(Color.BLACK);
        getPanelCadastro().add(ruatxt2);

        JLabel numerotxt2 = new JLabel("Número");
        numerotxt2.setBounds(385,325,100,20);
        numerotxt2.setFont(new Font("Arial",Font.BOLD,14));
        numerotxt2.setForeground(Color.BLACK);
        getPanelCadastro().add(numerotxt2);

        JLabel bairrotxt2 = new JLabel("Bairro");
        bairrotxt2.setBounds(385,375,100,20);
        bairrotxt2.setFont(new Font("Arial",Font.BOLD,14));
        bairrotxt2.setForeground(Color.BLACK);
        getPanelCadastro().add(bairrotxt2);

        JLabel cidadetxt2 = new JLabel("Cidade");
        cidadetxt2.setBounds(385,423,100,20);
        cidadetxt2.setFont(new Font("Arial",Font.BOLD,14));
        cidadetxt2.setForeground(Color.BLACK);
        getPanelCadastro().add(cidadetxt2);

        JLabel estadotxt2 = new JLabel("Estado");
        estadotxt2.setBounds(385,472,100,20);
        estadotxt2.setFont(new Font("Arial",Font.BOLD,14));
        estadotxt2.setForeground(Color.BLACK);
        getPanelCadastro().add(estadotxt2);

        // Fields da tabela inferior de endereço
        getFieldCEP().setVisible(false);
        getFieldCEP().setBounds(385,250,260,26);
        getPanelCadastro().add(getFieldCEP());

        getFieldRua().setVisible(false);
        getFieldRua().setBounds(385,299,260,26);
        getPanelCadastro().add(getFieldRua());

        getFieldNumero().setVisible(false);
        getFieldNumero().setBounds(385,348,260,26);
        getPanelCadastro().add(getFieldNumero());

        getFieldBairro().setVisible(false);
        getFieldBairro().setBounds(385,397,260,26);
        getPanelCadastro().add(getFieldBairro());

        getFieldCidade().setVisible(false);
        getFieldCidade().setBounds(385,446,260,26);
        getPanelCadastro().add(getFieldCidade());

        getFieldEstado().setVisible(false);
        getFieldEstado().setBounds(385,495,260,26);
        getPanelCadastro().add(getFieldEstado());

        // Botão de alterar endereço do usuario
        getBtnAlterarEndereco().setVisible(false);
        getBtnAlterarEndereco().setBounds(480, 522, 70, 25);
        getPanelCadastro().add(getBtnAlterarEndereco());

        // --- TABELA DADOS ATUAIS (TABELA MENOR SUPERIOR) ---
        JPanel panelDadosAtual = new JPanel();
        panelDadosAtual.setBorder(BorderFactory.createTitledBorder(""));
        panelDadosAtual.setBounds(22,40,309,140);
        getPanelCadastro().add(panelDadosAtual);

        // - PAINEL DADOS DO USUARIO (TABELA MAIOR) -
        JPanel panelDados = new JPanel();
        panelDados.setBorder(BorderFactory.createTitledBorder("DADOS DO USUÁRIO"));
        panelDados.setBounds(8,7,340,410);
        getPanelCadastro().add(panelDados);

        // --- TABELA DE ENDEREÇO ATUAL (TABELA MENOR SUPERIOR) ---
        JPanel panelEnderecoAtual = new JPanel();
        panelEnderecoAtual.setBorder(BorderFactory.createTitledBorder(""));
        panelEnderecoAtual.setBounds(370,40,290,177);
        getPanelCadastro().add(panelEnderecoAtual);

        // - PAINEL DE ENDEREÇO (TABELA MAIOR)-
        JPanel panelEndereco = new JPanel();
        panelEndereco.setBorder(BorderFactory.createTitledBorder("                                                       " +
                "ENDEREÇO DO USUÁRIO"));
        panelEndereco.setBounds(354,7,320,553);
        getPanelCadastro().add(panelEndereco);

        // LOGIN DO USUARIO
        JPanel panelUsuario = new JPanel();
        panelUsuario.setBorder(BorderFactory.createTitledBorder("LOGIN DO USUÁRIO"));
        panelUsuario.setBounds(8,415,340,146);
        getPanelCadastro().add(panelUsuario);
        // -------------------------------------------FIM CADASTRO-------------------------------------------------- //

        // ------------------------------------------------------------------------------------------------------------
        // - TELA DE AJUDA DA OPÇÃO DE MENU AJUDA -
        getPanelAjuda().setBounds(280,0,705,562);
        getPanelAjuda().setLayout(null);
        getFrameMenu().add(getPanelAjuda());
        //texto
        JLabel txtAjuda = new JLabel("AJUDA");
        txtAjuda.setBounds(300,20,200,20);
        txtAjuda.setFont(new Font("Arial",Font.BOLD,18));
        txtAjuda.setForeground(Color.BLACK);
        getPanelAjuda().add(txtAjuda);
        // -------------------------------------------FIM AJUDA----------------------------------------------------- //

        // Apenas um panel de fundo
        JPanel panelFundo = new JPanel();
        getFrameMenu().add(panelFundo);

        // Iniciando
        getFrameMenu().setVisible(true); // frameM de menu visivel
        JOptionPane.showMessageDialog(null, "Seja bem-vindo ao Controle de Energia!");
    }
}
