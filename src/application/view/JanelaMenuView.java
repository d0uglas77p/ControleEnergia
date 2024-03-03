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


public class JanelaMenuView extends JanelaMenuEvents {

    private EnderecoDAO enderecoDAO;
    private CompanhiaDAO companhiaDAO;

    public JanelaMenuView(Usuario usuario) throws SQLException {
        this.enderecoDAO = new EnderecoDAO();
        this.companhiaDAO = new CompanhiaDAO();


        // Instanciando o frameMenu
        getFrameMenu().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrameMenu().setSize(1000,600); // Dimensão do frameMenu
        getFrameMenu().setResizable(false);
        getFrameMenu().setLocationRelativeTo(null);

        // MENU
        // --------------------------------------------------------------------------------------------------------- //
        // Painel de Menu, onde fica as opções do menu
        JPanel panelMenu = new JPanel(); // Cria o painel de menu
        panelMenu.setSize(260,600); // Dimensão
        Color transparentBlack = new Color(0,0,0, 255); // Cor
        panelMenu.setBackground(transparentBlack); // Aplicando cor
        getFrameMenu().add(panelMenu); // Adiciona panelMenu no frameMenu
        panelMenu.setLayout(null); // Seta o painel de menu como layout padrão

        // Texto Controle de Energia
        JLabel txtControleEnergia = new JLabel("Controle de Energia"); // Cria o texto
        txtControleEnergia.setBounds(45,20,200,20); // Posição e tamanho do texto
        txtControleEnergia.setFont(new Font("Arial",Font.BOLD,18)); // Fonte do texto
        txtControleEnergia.setForeground(Color.WHITE); // Cor do texto
        panelMenu.add(txtControleEnergia); // Adiciona o texto no painel de menu

        // Icones das opções de menu
        ImageIcon iconInicio = new ImageIcon(Main.class.getResource("/application/view/icons/inicio.png")); // Cria imagem da lampada e o caminho
        getIconInicio().setIcon(iconInicio); // Seta o icone
        getIconInicio().setBounds(75,65,150,150); // Posição da imagem e tamanho
        getIconInicio().setVisible(true);
        panelMenu.add(getIconInicio()); // Adiciona a imagem no painel de menu

        ImageIcon iconAparelho = new ImageIcon(Main.class.getResource("/application/view/icons/aparelhos.png")); // Cria imagem da lampada e o caminho
        getIconAparelhos().setIcon(iconAparelho); // Seta o icone
        getIconAparelhos().setBounds(75,65,150,150); // Posição da imagem e tamanho
        getIconAparelhos().setVisible(false);
        panelMenu.add(getIconAparelhos()); // Adiciona a imagem no painel de menu

        ImageIcon iconCompanhia = new ImageIcon(Main.class.getResource("/application/view/icons/companhia.png")); // Cria imagem da lampada e o caminho
        getIconCompanhia().setIcon(iconCompanhia); // Seta o icone
        getIconCompanhia().setBounds(75,65,150,150); // Posição da imagem e tamanho
        getIconCompanhia().setVisible(false);
        panelMenu.add(getIconCompanhia()); // Adiciona a imagem no painel de menu

        ImageIcon iconCadastro = new ImageIcon(Main.class.getResource("/application/view/icons/cadastro.png")); // Cria imagem da lampada e o caminho
        getIconCadastro().setIcon(iconCadastro); // Seta o icone
        getIconCadastro().setBounds(75,65,150,150); // Posição da imagem e tamanho
        getIconCadastro().setVisible(false);
        panelMenu.add(getIconCadastro()); // Adiciona a imagem no painel de menu

        ImageIcon iconAjuda = new ImageIcon(Main.class.getResource("/application/view/icons/ajuda.png")); // Cria imagem da lampada e o caminho
        getIconAjuda().setIcon(iconAjuda); // Seta o icone
        getIconAjuda().setBounds(75,65,150,150); // Posição da imagem e tamanho
        getIconAjuda().setVisible(false);
        panelMenu.add(getIconAjuda()); // Adiciona a imagem no painel de menu


        // label txt usuario
        JLabel labelUsuariotxt = new JLabel("Usuário:");
        labelUsuariotxt.setBounds(10,535,200,20);
        labelUsuariotxt.setFont(new Font("Calibri", Font.PLAIN,12));
        Color colorLogado = new Color(0, 255, 247, 255); // Cor
        labelUsuariotxt.setForeground(colorLogado);
        panelMenu.add(labelUsuariotxt);
        // Nome do usuario logado no painel de menu opções, canto inferior esquerdo
        getLogado().setText(usuario.getUsuario()); // Adiciona uma label do usuario vindo do banco de dados
        getLogado().setBounds(60,535,200,20); // Posição e tamanho do texto
        getLogado().setFont(new Font("Calibri",Font.PLAIN,12)); // Fonte do texto
        getLogado().setForeground(colorLogado); // Cor do texto
        panelMenu.add(getLogado()); // Adiciona o texto no painel de menu



        // Botão de Inicio
        getBtnInicio().setBounds(-10,260,280,40); // Posição e tamanho do botão
        getBtnInicio().setForeground(Color.WHITE); // Cor do texto do botão
        getBtnInicio().setFont(new Font("Arial",Font.BOLD,14)); // Fonte
        // Configuração da borda do botão
        getBtnInicio().setFocusPainted(false);
        getBtnInicio().setBorderPainted(false);
        getBtnInicio().setBackground(transparentBlack); // Cor do botão
        panelMenu.add(getBtnInicio()); // Adiciona o botão no  painel de menu

        // Botão de aparelhos
        getBtnAparelhos().setBounds(-10,299,280,40); // Posição e tamanho do botão
        getBtnAparelhos().setForeground(Color.WHITE); // Cor do texto do botão
        getBtnAparelhos().setFont(new Font("Arial",Font.BOLD,14)); // Fonte
        // Configuração da borda do botão
        getBtnAparelhos().setFocusPainted(false);
        getBtnAparelhos().setBorderPainted(false);
        getBtnAparelhos().setBackground(transparentBlack); // Cor do botão
        panelMenu.add(getBtnAparelhos()); // Adiciona o botão  no painel de menu

        // Botão de companhia
        getBtnCompanhia().setBounds(-10,338,280,40); // Posição e tamanho do botão
        getBtnCompanhia().setForeground(Color.WHITE); // Cor do texto do botão
        getBtnCompanhia().setFont(new Font("Arial",Font.BOLD,14)); // Fonte
        // Configuração da borda do botão
        getBtnCompanhia().setFocusPainted(false);
        getBtnCompanhia().setBorderPainted(false);
        getBtnCompanhia().setBackground(transparentBlack); // Cor do botão
        panelMenu.add(getBtnCompanhia()); // Adiciona o botão  no painel de menu

        // Botão de cadastro
        getBtnCadastro().setBounds(-10,377,280,40); // Posição e tamanho do botão
        getBtnCadastro().setForeground(Color.WHITE); // Cor do texto do botão
        getBtnCadastro().setFont(new Font("Arial",Font.BOLD,14)); // Fonte
        // Configuração da borda do botão
        getBtnCadastro().setFocusPainted(false);
        getBtnCadastro().setBorderPainted(false);
        getBtnCadastro().setBackground(transparentBlack); // Cor do botão
        panelMenu.add(getBtnCadastro()); // Adiciona o botão  no painel de menu


        // Botão de ajuda
        getBtnAjuda().setBounds(-10,416,280,40); // Posição e tamanho do botão
        getBtnAjuda().setForeground(Color.WHITE); // Cor do texto do botão
        getBtnAjuda().setFont(new Font("Arial",Font.BOLD,14)); // Fonte
        // Configuração da borda do botão
        getBtnAjuda().setFocusPainted(false);
        getBtnAjuda().setBorderPainted(false);
        getBtnAjuda().setBackground(transparentBlack); // Cor do botão
        panelMenu.add(getBtnAjuda()); // Adiciona o botão  no painel de menu

        // Botão de sair
        getBtnSair().setBounds(-10,455,280,40); // Posição e tamanho do botão
        getBtnSair().setForeground(Color.WHITE); // Cor do texto do botão
        getBtnSair().setFont(new Font("Arial",Font.BOLD,14)); // Fonte
        // Configuração da borda do botão
        getBtnSair().setFocusPainted(false);
        getBtnSair().setBorderPainted(false);
        getBtnSair().setBackground(transparentBlack); // Cor do botão
        panelMenu.add(getBtnSair()); // Adiciona o botão  no painel de menu
        // -------------------------------------------FIM MENU------------------------------------------------------- //



        // TELAS DAS OPÇÕES DE MENU
        // --------------------------------------------------------------------------------------------------------- //
        // - TELA DE INICIO DA OPÇÃO DE MENU INICIO -
        getPanelInicio().setBounds(280,0,705,562); // Posição e tamanho do painel
        getPanelInicio().setLayout(null); // Seta a tela como layout padrão
        getFrameMenu().add(getPanelInicio()); // Adiciona panelMenu no frameMenu
        //texto
        JLabel txtInicio = new JLabel("INICIO"); // Titulo
        txtInicio.setBounds(300,20,100,20); // Posição e tamanho do texto
        txtInicio.setFont(new Font("Arial",Font.BOLD,18)); // Fonte do texto
        txtInicio.setForeground(Color.BLACK); // Cor do texto
        getPanelInicio().add(txtInicio); // Adiciona o texto na tela
        // -------------------------------------------FIM INICIO---------------------------------------------------- //


        // --------------------------------------------------------------------------------------------------------- //
        // - TELA DE APARELHOS DA OPÇÃO DE MENU APARELHOS -
        getPanelAparelhos().setBounds(280,0,705,562); // Posição e tamanho do painel
        getPanelAparelhos().setLayout(null); // Seta a tela como layout padrão
        getFrameMenu().add(getPanelAparelhos()); // Adiciona panelMenu no frameMenu
        //texto
        JLabel txtAparelhos = new JLabel("APARELHOS"); // Titulo
        txtAparelhos.setBounds(300,20,200,20); // Posição e tamanho do texto
        txtAparelhos.setFont(new Font("Arial",Font.BOLD,18)); // Fonte do texto
        txtAparelhos.setForeground(Color.BLACK); // Cor do texto
        getPanelAparelhos().add(txtAparelhos); // Adiciona o texto na tela
        // -------------------------------------------FIM APARELHOS------------------------------------------------- //


        // --------------------------------------------------------------------------------------------------------- //
        // - TELA DE COMPANHIA DA OPÇÃO DE MENU COMPANHIA -
        getPanelCompanhia().setBounds(280,0,705,562); // Posição e tamanho do painel
        getPanelCompanhia().setLayout(null); // Seta a tela como layout padrão
        getFrameMenu().add(getPanelCompanhia()); // Adiciona panelMenu no frameMenu

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

        getSubGrupo().add(getMediaTensao());
        getSubGrupo().add(getAltaTensao());
        getSubGrupo().add(getResidencial());
        getSubGrupo().add(getRural());
        getSubGrupo().add(getOutros());

        JLabel tipoFornecimentotxt = new JLabel("Tipo de Fornecimento");
        tipoFornecimentotxt.setBounds(35,275,300,20);
        tipoFornecimentotxt.setFont(new Font("Arial", Font.BOLD, 14));
        tipoFornecimentotxt.setForeground(Color.BLACK);
        getPanelCompanhia().add(tipoFornecimentotxt);

        getComboTipoFornecimento().setVisible(false);
        getComboTipoFornecimento().setBounds(190,273,125,25);
        getPanelCompanhia().add(getComboTipoFornecimento());

        getComboTipoFornecimento().addItem("Monofásico");
        getComboTipoFornecimento().addItem("Bifásico");
        getComboTipoFornecimento().addItem("Trifásico");

        JLabel numMedidortxt = new JLabel("N° do Medidor");
        numMedidortxt.setBounds(35,320,300,20);
        numMedidortxt.setFont(new Font("Arial", Font.BOLD, 14));
        numMedidortxt.setForeground(Color.BLACK);
        getPanelCompanhia().add(numMedidortxt);

        getFieldNumMedidor().setVisible(false);
        getFieldNumMedidor().setBounds(140,318,175,26);
        getPanelCompanhia().add(getFieldNumMedidor());


        // Painel de classificação da instalação de energia
        JPanel panelClassificacao = new JPanel();
        panelClassificacao.setBorder(BorderFactory.createTitledBorder("CLASSIFICAÇÃO")); // Borda personalizada do painel
        panelClassificacao.setBounds(20,175,309,200); // Posição e tamanho do painel
        getPanelCompanhia().add(panelClassificacao);


        JLabel tarifaTxt = new JLabel("Tarifa de Energia");
        tarifaTxt.setBounds(370,54,300,20);
        tarifaTxt.setFont(new Font("Arial", Font.BOLD, 14));
        tarifaTxt.setForeground(Color.BLACK);
        getPanelCompanhia().add(tarifaTxt);

        getFieldTarifa().setVisible(false);
        getFieldTarifa().setBounds(500,52,140,26);
        getPanelCompanhia().add(getFieldTarifa());


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

        getCadastrarCompanhia().setVisible(false);
        getCadastrarCompanhia().setBounds(450,350,90,26);
        getCadastrarCompanhia().setFont(new Font("Arial",Font.BOLD,12)); // Fonte do texto
        getPanelCompanhia().add(getCadastrarCompanhia());


        // Painel de encargos da companhia
        JPanel panelEncargo = new JPanel();
        panelEncargo.setBorder(BorderFactory.createTitledBorder("ENCARGOS")); // Borda personalizada do painel
        panelEncargo.setBounds(350,25,309,325); // Posição e tamanho do painel
        getPanelCompanhia().add(panelEncargo);


        List<Companhia> companhiasUsuario = companhiaDAO.buscarCompanhias(usuario.getId());

        if (!companhiasUsuario.isEmpty()) {
            // Nome das colunas
            String[] header = {"Nome", "CNPJ", "Telefone", "Fornecimento", "Medidor", "Tarifa"};

            String[][] data = new String[companhiasUsuario.size()][header.length];

            for (int i = 0; i < companhiasUsuario.size(); i++) {
                Companhia companhia = companhiasUsuario.get(i);
                data[i] = new String[] {
                        companhia.getNomeCompanhia(),
                        companhia.getCnpj(),
                        companhia.getTelefoneCompanhia(),
                        companhia.getTipoFornecimento(),
                        companhia.getMedidor(),
                        companhia.getTarifa(),
                };
            }

            // Modelo das celulas
            DefaultTableModel model = new DefaultTableModel(data, header);

            // Criar a tabela
            getTabelaCompanhia();
            JScrollPane scrollPane = new JScrollPane(getTabelaCompanhia());
            scrollPane.setBounds(25,400,630,130);
            getPanelCompanhia().add(scrollPane);

        } else {
        }

        // -------------------------------------------FIM COMPANHIA------------------------------------------------- //


        // --------------------------------------------------------------------------------------------------------- //
        // - TELA DE CADASTRO DA OPÇÃO DE MENU CADASTRO -
        getPanelCadastro().setBounds(280,0,705,562); // Posição e tamanho da tela
        getPanelCadastro().setLayout(null); // Seta a tela como layout padrão
        getFrameMenu().add(getPanelCadastro()); // Adiciona panelMenu no frameMenu

        // ELEMENTOS DA TABELA DO PAINEL DE CADASTRO
        // Labels da tabela de dados atuais
        JLabel nometxt = new JLabel("Nome:");
        nometxt.setBounds(36,50,100,20); // Posição e tamanho do texto
        nometxt.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        nometxt.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(nometxt); // Adiciona o texto na tela de cadastro

        JLabel sobrenometxt = new JLabel("Sobrenome:");
        sobrenometxt.setBounds(36,75,100,20); // Posição e tamanho do texto
        sobrenometxt.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        sobrenometxt.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(sobrenometxt); // Adiciona o texto na tela de cadastro

        JLabel telefonetxt = new JLabel("Telefone:");
        telefonetxt.setBounds(36,99,100,20); // Posição e tamanho do texto
        telefonetxt.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        telefonetxt.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(telefonetxt); // Adiciona o texto na tela de cadastro

        JLabel emailtxt = new JLabel("Email:");
        emailtxt.setBounds(36,125,100,20); // Posição e tamanho do texto
        emailtxt.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        emailtxt.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(emailtxt); // Adiciona o texto na tela de cadastro

        JLabel dtnascimentotxt = new JLabel("Data de Nascimento:");
        dtnascimentotxt.setBounds(36,150,160,20); // Posição e tamanho do texto
        dtnascimentotxt.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        dtnascimentotxt.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(dtnascimentotxt); // Adiciona o texto na tela de cadastro

        // Labels que pega os dados do usuario da tabela de dados atuais
        getNomebd().setText(usuario.getNome());
        getNomebd().setBounds(87,53,200,20); // Posição e tamanho do texto
        getNomebd().setFont(new Font("Calibri",Font.PLAIN,16)); // Fonte do texto
        getPanelCadastro().add(getNomebd()); // Adiciona o texto de dados do usuario na tela de cadastro

        getSobrenomebd().setText(usuario.getSobrenome());
        getSobrenomebd().setBounds(130,78,200,20); // Posição e tamanho do texto
        getSobrenomebd().setFont(new Font("Calibri",Font.PLAIN,16)); // Fonte do texto
        getPanelCadastro().add(getSobrenomebd()); // Adiciona o texto de dados do usuario na tela de cadastro

        getTelefonebd().setText(usuario.getTelefone());
        getTelefonebd().setBounds(107,102,200,20); // Posição e tamanho do texto
        getTelefonebd().setFont(new Font("Calibri",Font.PLAIN,16)); // Fonte do texto
        getPanelCadastro().add(getTelefonebd()); // Adiciona o texto de dados do usuario na tela de cadastro

        getEmailbd().setText(usuario.getEmail());
        getEmailbd().setBounds(85,128,300,20); // Posição e tamanho do texto
        getEmailbd().setFont(new Font("Calibri",Font.PLAIN,16)); // Fonte do texto
        getPanelCadastro().add(getEmailbd()); // Adiciona o texto de dados do usuario na tela de cadastro

        JLabel dtnascimentobd = new JLabel();
        dtnascimentobd.setText(usuario.getDtNascimento());
        dtnascimentobd.setBounds(185,154,200,20); // Posição e tamanho do texto
        dtnascimentobd.setFont(new Font("Calibri",Font.PLAIN,16)); // Fonte do texto
        getPanelCadastro().add(dtnascimentobd); // Adiciona o texto de dados do usuario na tela de cadastro

        // Labels da tabela inferior de alterar dados
        JLabel nometxt2 = new JLabel("Nome");
        nometxt2.setBounds(36,185,100,20); // Posição e tamanho do texto
        nometxt2.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        nometxt2.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(nometxt2); // Adiciona o texto de dados do usuario na tela de cadastro

        JLabel sobrenometxt2 = new JLabel("Sobrenome");
        sobrenometxt2.setBounds(36,230,100,20); // Posição e tamanho do texto
        sobrenometxt2.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        sobrenometxt2.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(sobrenometxt2); // Adiciona o texto de dados do usuario na tela de cadastro

        JLabel telefonetxt2 = new JLabel("Telefone");
        telefonetxt2.setBounds(36,275,100,20); // Posição e tamanho do texto
        telefonetxt2.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        telefonetxt2.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(telefonetxt2); // Adiciona o texto de dados do usuario na tela de cadastro


        JLabel emailtxt2 = new JLabel("Email");
        emailtxt2.setBounds(36,325,100,20); // Posição e tamanho do texto
        emailtxt2.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        emailtxt2.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(emailtxt2); // Adiciona o texto de dados do usuario na tela de cadastro


        // Fields da tabela inferior de alterar dados
        getFieldNovoNome().setVisible(false); // Aciona como visibilidade nula, para ser acionado quando clicar apenas na opção de cadastro
        getFieldNovoNome().setBounds(36,205,276,26); // Posição e tamanho do field
        getPanelCadastro().add(getFieldNovoNome()); // Adiciona o field na tela de cadastro, para alterar os dados

        getFieldNovoSobrenome().setVisible(false); // Aciona como visibilidade nula, para ser acionado quando clicar apenas na opção de cadastro
        getFieldNovoSobrenome().setBounds(36,250,276,26); // Posição e tamanho do field
        getPanelCadastro().add(getFieldNovoSobrenome()); // Adiciona o field na tela de cadastro, para alterar os dados

        getFieldNovoTelefone().setVisible(false); // Aciona como visibilidade nula, para ser acionado quando clicar apenas na opção de cadastro
        getFieldNovoTelefone().setBounds(36,299,276,26); // Posição e tamanho do field
        getPanelCadastro().add(getFieldNovoTelefone()); // Adiciona o field na tela de cadastro, para alterar os dados

        getFieldNovoEmail().setVisible(false); // Aciona como visibilidade nula, para ser acionado quando clicar apenas na opção de cadastro
        getFieldNovoEmail().setBounds(36,348,276,26); // Posição e tamanho do field
        getPanelCadastro().add(getFieldNovoEmail()); // Adiciona o field na tela de cadastro, para alterar os dados

        // Botão de alterar dados do usuario
        getBtnAlterarDados().setVisible(false);
        getBtnAlterarDados().setBounds(140, 380, 70, 25);
        getPanelCadastro().add(getBtnAlterarDados());


        // Labels da tabela de login
        JLabel logintxt = new JLabel("Login:");
        logintxt.setBounds(36,455,100,20); // Posição e tamanho do texto
        logintxt.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        logintxt.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(logintxt); // Adiciona o texto de login do usuario na tela de cadastro

        JLabel senhatxt = new JLabel("Senha:");
        senhatxt.setBounds(34,489,100,20); // Posição e tamanho do texto
        senhatxt.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        senhatxt.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(senhatxt); // Adiciona o texto de login do usuario na tela de cadastro

        // Fields da tabela de login
        getFieldNovoLogin().setVisible(false); // Aciona como visibilidade nula, para ser acionado quando clicar apenas na opção de cadastro
        getFieldNovoLogin().setBounds(87,452,225,26); // Posição e tamanho do field
        getPanelCadastro().add(getFieldNovoLogin()); // Adiciona o field na tela de cadastro, para alterar o login

        getFielNovaSenha().setVisible(false); // Aciona como visibilidade nula, para ser acionado quando clicar apenas na opção de cadastro
        getFielNovaSenha().setBounds(87,488,225,26); // Posição e tamanho do field
        getPanelCadastro().add(getFielNovaSenha()); // Adiciona o field na tela de cadastro, para alterar o login


        // Botão de excluir usuario
        getBtnExcluirUsuario().setVisible(false);
        getBtnExcluirUsuario().setBounds(125, 522, 110, 25);
        getPanelCadastro().add(getBtnExcluirUsuario());


        // Labels da tabela de endereço atual
        JLabel ceptxt = new JLabel("CEP:");
        ceptxt.setBounds(385,50,100,20); // Posição e tamanho do texto
        ceptxt.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        ceptxt.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(ceptxt); // Adiciona o texto na tela de cadastro

        JLabel ruatxt = new JLabel("Rua:");
        ruatxt.setBounds(385,75,100,20); // Posição e tamanho do texto
        ruatxt.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        ruatxt.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(ruatxt); // Adiciona o texto na tela de cadastro

        JLabel numerotxt = new JLabel("Número:");
        numerotxt.setBounds(385,99,100,20); // Posição e tamanho do texto
        numerotxt.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        numerotxt.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(numerotxt); // Adiciona o texto na tela de cadastro

        JLabel bairrotxt = new JLabel("Bairro:");
        bairrotxt.setBounds(385,125,100,20); // Posição e tamanho do texto
        bairrotxt.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        bairrotxt.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(bairrotxt); // Adiciona o texto na tela de cadastro

        JLabel cidadetxt = new JLabel("Cidade:");
        cidadetxt.setBounds(385,150,100,20); // Posição e tamanho do texto
        cidadetxt.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        cidadetxt.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(cidadetxt); // Adiciona o texto na tela de cadastro

        JLabel estadotxt = new JLabel("Estado:");
        estadotxt.setBounds(385,175,100,20); // Posição e tamanho do texto
        estadotxt.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        estadotxt.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(estadotxt); // Adiciona o texto na tela de cadastro

        // Labels que pega o endereço do usuario da tabela de endereço atual
        Endereco enderecoUsuario = enderecoDAO.buscarEndereco(usuario.getId());

        if (enderecoUsuario != null) {
            getCepbd().setText(enderecoUsuario.getCep());
            getCepbd().setBounds(425,53,200,20); // Posição e tamanho do texto
            getCepbd().setFont(new Font("Calibri",Font.PLAIN,16)); // Fonte do texto
            getPanelCadastro().add(getCepbd()); // Adiciona o texto de dados do usuario na tela de cadastro

            getRuabd().setText(enderecoUsuario.getRua());
            getRuabd().setBounds(425,78,200,20); // Posição e tamanho do texto
            getRuabd().setFont(new Font("Calibri",Font.PLAIN,16)); // Fonte do texto
            getPanelCadastro().add(getRuabd()); // Adiciona o texto de dados do usuario na tela de cadastro

            getNumerobd().setText(enderecoUsuario.getNumero());
            getNumerobd().setBounds(450,102,200,20); // Posição e tamanho do texto
            getNumerobd().setFont(new Font("Calibri",Font.PLAIN,16)); // Fonte do texto
            getPanelCadastro().add(getNumerobd()); // Adiciona o texto de dados do usuario na tela de cadastro

            getBairrobd().setText(enderecoUsuario.getBairro());
            getBairrobd().setBounds(440,128,200,20); // Posição e tamanho do texto
            getBairrobd().setFont(new Font("Calibri",Font.PLAIN,16)); // Fonte do texto
            getPanelCadastro().add(getBairrobd()); // Adiciona o texto de dados do usuario na tela de cadastro

            getCidadebd().setText(enderecoUsuario.getCidade());
            getCidadebd().setBounds(445,153,200,20); // Posição e tamanho do texto
            getCidadebd().setFont(new Font("Calibri",Font.PLAIN,16)); // Fonte do texto
            getPanelCadastro().add(getCidadebd()); // Adiciona o texto de dados do usuario na tela de cadastro

            getEstadobd().setText(enderecoUsuario.getEstado());
            getEstadobd().setBounds(445,178,200,20); // Posição e tamanho do texto
            getEstadobd().setFont(new Font("Calibri",Font.PLAIN,16)); // Fonte do texto
            getPanelCadastro().add(getEstadobd()); // Adiciona o texto de dados do usuario na tela de cadastro
        } else {

        }

        // Labels da tabela inferior de alterar endereço
        JLabel ceptxt2 = new JLabel("CEP");
        ceptxt2.setBounds(385,230,100,20); // Posição e tamanho do texto
        ceptxt2.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        ceptxt2.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(ceptxt2); // Adiciona o texto de dados do usuario na tela de cadastro

        JLabel ruatxt2 = new JLabel("Rua");
        ruatxt2.setBounds(385,275,100,20); // Posição e tamanho do texto
        ruatxt2.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        ruatxt2.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(ruatxt2); // Adiciona o texto de dados do usuario na tela de cadastro

        JLabel numerotxt2 = new JLabel("Número");
        numerotxt2.setBounds(385,325,100,20); // Posição e tamanho do texto
        numerotxt2.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        numerotxt2.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(numerotxt2); // Adiciona o texto de dados do usuario na tela de cadastro

        JLabel bairrotxt2 = new JLabel("Bairro");
        bairrotxt2.setBounds(385,375,100,20); // Posição e tamanho do texto
        bairrotxt2.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        bairrotxt2.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(bairrotxt2); // Adiciona o texto de dados do usuario na tela de cadastro

        JLabel cidadetxt2 = new JLabel("Cidade");
        cidadetxt2.setBounds(385,423,100,20); // Posição e tamanho do texto
        cidadetxt2.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        cidadetxt2.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(cidadetxt2); // Adiciona o texto de dados do usuario na tela de cadastro

        JLabel estadotxt2 = new JLabel("Estado");
        estadotxt2.setBounds(385,472,100,20); // Posição e tamanho do texto
        estadotxt2.setFont(new Font("Arial",Font.BOLD,14)); // Fonte do texto
        estadotxt2.setForeground(Color.BLACK); // Cor do texto
        getPanelCadastro().add(estadotxt2); // Adiciona o texto de dados do usuario na tela de cadastro

        // Fields da tabela inferior de endereço
        getFieldCEP().setVisible(false); // Aciona como visibilidade nula, para ser acionado quando clicar apenas na opção de cadastro
        getFieldCEP().setBounds(385,250,260,26); // Posição e tamanho do field
        getPanelCadastro().add(getFieldCEP()); // Adiciona o field na tela de cadastro, para alterar os endereço

        getFieldRua().setVisible(false); // Aciona como visibilidade nula, para ser acionado quando clicar apenas na opção de cadastro
        getFieldRua().setBounds(385,299,260,26); // Posição e tamanho do field
        getPanelCadastro().add(getFieldRua()); // Adiciona o field na tela de cadastro, para alterar os endereço

        getFieldNumero().setVisible(false); // Aciona como visibilidade nula, para ser acionado quando clicar apenas na opção de cadastro
        getFieldNumero().setBounds(385,348,260,26); // Posição e tamanho do field
        getPanelCadastro().add(getFieldNumero()); // Adiciona o field na tela de cadastro, para alterar os endereço

        getFieldBairro().setVisible(false); // Aciona como visibilidade nula, para ser acionado quando clicar apenas na opção de cadastro
        getFieldBairro().setBounds(385,397,260,26); // Posição e tamanho do field
        getPanelCadastro().add(getFieldBairro()); // Adiciona o field na tela de cadastro, para alterar os endereço

        getFieldCidade().setVisible(false); // Aciona como visibilidade nula, para ser acionado quando clicar apenas na opção de cadastro
        getFieldCidade().setBounds(385,446,260,26); // Posição e tamanho do field
        getPanelCadastro().add(getFieldCidade()); // Adiciona o field na tela de cadastro, para alterar os endereço

        getFieldEstado().setVisible(false); // Aciona como visibilidade nula, para ser acionado quando clicar apenas na opção de cadastro
        getFieldEstado().setBounds(385,495,260,26); // Posição e tamanho do field
        getPanelCadastro().add(getFieldEstado()); // Adiciona o field na tela de cadastro, para alterar os endereço


        // Botão de alterar endereço do usuario
        getBtnAlterarEndereco().setVisible(false);
        getBtnAlterarEndereco().setBounds(480, 522, 70, 25);
        getPanelCadastro().add(getBtnAlterarEndereco());


        // --- TABELA DADOS ATUAIS (TABELA MENOR SUPERIOR) ---
        JPanel panelDadosAtual = new JPanel();
        panelDadosAtual.setBorder(BorderFactory.createTitledBorder("")); // Borda personalizada do painel
        panelDadosAtual.setBounds(22,40,309,140); // Posição e tamanho do painel
        getPanelCadastro().add(panelDadosAtual);


        // - PAINEL DADOS DO USUARIO (TABELA MAIOR) -
        JPanel panelDados = new JPanel(); // Painel de dados do usuario maior que contem as tabelas de inferiores
        panelDados.setBorder(BorderFactory.createTitledBorder("DADOS DO USUÁRIO")); // Borda personalizada do painel
        panelDados.setBounds(8,7,340,410); // Posição e tamanho do painel
        getPanelCadastro().add(panelDados); // Adiciona o painel de dados do usuario no painel da tela de menu


        // --- TABELA DE ENDEREÇO ATUAL (TABELA MENOR SUPERIOR) ---
        JPanel panelEnderecoAtual = new JPanel();
        panelEnderecoAtual.setBorder(BorderFactory.createTitledBorder("")); // Borda personalizada do painel
        panelEnderecoAtual.setBounds(370,40,290,177); // Posição e tamanho do painel
        getPanelCadastro().add(panelEnderecoAtual);


        // - PAINEL DE ENDEREÇO (TABELA MAIOR)-
        JPanel panelEndereco = new JPanel();
        panelEndereco.setBorder(BorderFactory.createTitledBorder("                                                       " +
                "ENDEREÇO DO USUÁRIO")); // Borda personalizada do painel
        panelEndereco.setBounds(354,7,320,553); // Posição e tamanho do painel
        getPanelCadastro().add(panelEndereco);

        // LOGIN DO USUARIO
        JPanel panelUsuario = new JPanel();
        panelUsuario.setBorder(BorderFactory.createTitledBorder("LOGIN DO USUÁRIO")); // Borda personalizada do painel
        panelUsuario.setBounds(8,415,340,146); // Posição e tamanho do painel
        getPanelCadastro().add(panelUsuario);
        // -------------------------------------------FIM CADASTRO-------------------------------------------------- //




        // ------------------------------------------------------------------------------------------------------------
        // - TELA DE AJUDA DA OPÇÃO DE MENU AJUDA -
        getPanelAjuda().setBounds(280,0,705,562); // Posição e tamanho do painel
        getPanelAjuda().setLayout(null); // Seta a tela como layout padrão
        getFrameMenu().add(getPanelAjuda()); // Adiciona panelMenu no frameMenu
        //texto
        JLabel txtAjuda = new JLabel("AJUDA"); // Titulo
        txtAjuda.setBounds(300,20,200,20); // Posição e tamanho do texto
        txtAjuda.setFont(new Font("Arial",Font.BOLD,18)); // Fonte do texto
        txtAjuda.setForeground(Color.BLACK); // Cor do texto
        getPanelAjuda().add(txtAjuda); // Adiciona o texto na tela
        // -------------------------------------------FIM AJUDA----------------------------------------------------- //


        // Apenas um panel de fundo
        JPanel panelFundo = new JPanel();
        getFrameMenu().add(panelFundo);

        // Iniciando
        getFrameMenu().setVisible(true); // frameM de menu visivel
        JOptionPane.showMessageDialog(null, "Seja bem-vindo ao Controle de Energia!");
    }

}
