package application.view;

import application.Main;
import application.events.JanelaMenuEvents;
import application.model.DAO.AparelhoDAO;
import application.model.DAO.CompanhiaDAO;
import application.model.DAO.EnderecoDAO;
import application.model.entity.Aparelho;
import application.model.entity.Companhia;
import application.model.entity.Endereco;
import application.model.entity.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

// Classe front da Janela de Menu
public class JanelaMenuView extends JanelaMenuEvents {

    private EnderecoDAO enderecoDAO;
    private CompanhiaDAO companhiaDAO;
    private AparelhoDAO aparelhoDAO;

    public JanelaMenuView(Usuario usuario) throws SQLException {
        this.enderecoDAO = new EnderecoDAO();
        this.companhiaDAO = new CompanhiaDAO();
        this.aparelhoDAO = new AparelhoDAO();

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
        getPanelInicio().setBounds(250,0,765,562);
        getPanelInicio().setLayout(null);
        getFrameMenu().add(getPanelInicio());

        ImageIcon fundoInicioPane = new ImageIcon(Main.class.getResource("/application/view/icons/inicioPane.png"));
        getFundoInicioPane().setIcon(fundoInicioPane);
        getFundoInicioPane().setBounds(0,0,745,562);
        getFundoInicioPane().setVisible(true);
        getPanelInicio().add(getFundoInicioPane());


        // -------------------------------------------FIM INICIO---------------------------------------------------- //


        // --------------------------------------------------------------------------------------------------------- //
        // - TELA DE APARELHOS DA OPÇÃO DE MENU APARELHOS -
        getPanelAparelhos().setBounds(280,0,705,562);
        getPanelAparelhos().setLayout(null);
        getFrameMenu().add(getPanelAparelhos());

        // Labels da tela de aparelho
        JLabel aparelhotxt = new JLabel("Nome do Aparelho");
        aparelhotxt.setBounds(54,30,300,20);
        aparelhotxt.setFont(new Font("Arial", Font.BOLD, 14));
        aparelhotxt.setForeground(Color.BLACK);
        getPanelAparelhos().add(aparelhotxt);

        JLabel fabricantetxt = new JLabel("Nome do Fabricante");
        fabricantetxt.setBounds(54,75,300,20);
        fabricantetxt.setFont(new Font("Arial", Font.BOLD, 14));
        fabricantetxt.setForeground(Color.BLACK);
        getPanelAparelhos().add(fabricantetxt);

        JLabel marcatxt = new JLabel("Marca");
        marcatxt.setBounds(54,120,300,20);
        marcatxt.setFont(new Font("Arial", Font.BOLD, 14));
        marcatxt.setForeground(Color.BLACK);
        getPanelAparelhos().add(marcatxt);

        JLabel modelotxt = new JLabel("Modelo");
        modelotxt.setBounds(54,165,300,20);
        modelotxt.setFont(new Font("Arial", Font.BOLD, 14));
        modelotxt.setForeground(Color.BLACK);
        getPanelAparelhos().add(modelotxt);

        // Fields da tela de aparelhos
        getFieldNomeAparelho().setVisible(false);
        getFieldNomeAparelho().setBounds(54,50,300,26);
        getPanelAparelhos().add(getFieldNomeAparelho());

        getFieldNomeFabricante().setVisible(false);
        getFieldNomeFabricante().setBounds(54,95,300,26);
        getPanelAparelhos().add(getFieldNomeFabricante());

        getFieldMarca().setVisible(false);
        getFieldMarca().setBounds(54,140,300,26);
        getPanelAparelhos().add(getFieldMarca());

        getFieldModelo().setVisible(false);
        getFieldModelo().setBounds(54,185,300,26);
        getPanelAparelhos().add(getFieldModelo());

        // Painel de especificações do aparelho
        JPanel panelEspecificacao = new JPanel();
        panelEspecificacao.setBorder(BorderFactory.createTitledBorder("ESPECIFICAÇÃO"));
        panelEspecificacao.setBounds(36,10,336,225);
        getPanelAparelhos().add(panelEspecificacao);

        // Labels de potencia do aparelho
        JLabel voltstxt = new JLabel("Volts");
        voltstxt.setBounds(420,30,300,20);
        voltstxt.setFont(new Font("Arial", Font.BOLD, 14));
        voltstxt.setForeground(Color.BLACK);
        getPanelAparelhos().add(voltstxt);

        JLabel wattstxt = new JLabel("Watts");
        wattstxt.setBounds(420,75,300,20);
        wattstxt.setFont(new Font("Arial", Font.BOLD, 14));
        wattstxt.setForeground(Color.BLACK);
        getPanelAparelhos().add(wattstxt);

        // Fields da tela de aparelhos
        getFieldVolts().setVisible(false);
        getFieldVolts().setBounds(420,50,200,26);
        getPanelAparelhos().add(getFieldVolts());

        getFieldWatts().setVisible(false);
        getFieldWatts().setBounds(420,95,200,26);
        getPanelAparelhos().add(getFieldWatts());

        // Painel de potencia do aparelho
        JPanel panelPotencia = new JPanel();
        panelPotencia.setBorder(BorderFactory.createTitledBorder("POTÊNCIA"));
        panelPotencia.setBounds(400,10,240,130);
        getPanelAparelhos().add(panelPotencia);

        // Labels do tempo gasto do aparelho
        JLabel tempotxt = new JLabel("Tempo gasto por dia");
        tempotxt.setBounds(420,160,300,20);
        tempotxt.setFont(new Font("Arial", Font.BOLD, 14));
        tempotxt.setForeground(Color.BLACK);
        getPanelAparelhos().add(tempotxt);

        // Fields da tela de aparelhos
        getFieldTempo().setVisible(false);
        getFieldTempo().setBounds(570,158,50,26);
        getPanelAparelhos().add(getFieldTempo());

        JPanel panelTempo = new JPanel();
        panelTempo.setBorder(BorderFactory.createTitledBorder(""));
        panelTempo.setBounds(402,149,238,48);
        getPanelAparelhos().add(panelTempo);

        // Botão de cadastro de aparelho
        getBtnCadastrarAparelho().setVisible(false);
        getBtnCadastrarAparelho().setBounds(474,205,90,26);
        getBtnCadastrarAparelho().setFont(new Font("Arial",Font.BOLD,12));
        getPanelAparelhos().add(getBtnCadastrarAparelho());

        // lista de aparelhos cadastrados
        List<Aparelho> aparelhosUsuario = aparelhoDAO.buscarAparelhos(usuario.getId());


        // Nome das colunas
        String[] headerAparelho = {"Aparelho", "Fabricante", "Marca", "Modelo", "Volts", "Watts", "Tempo", "kWh"};

        String[][] dataAparelho = new String[aparelhosUsuario.size()][headerAparelho.length];

        if (!aparelhosUsuario.isEmpty()) {
            for (int i = 0; i < aparelhosUsuario.size(); i++) {
                Aparelho aparelho = aparelhosUsuario.get(i);

                String v = "v";
                String voltsString = aparelho.getVolts();

                String w = "w";
                String wattsString = aparelho.getWatts();

                String h = "h";
                String tempoString = aparelho.getTempo();
                double tempoDouble = Double.parseDouble(tempoString);
                DecimalFormat decimalConvertTempo = new DecimalFormat("0.00");
                String tempoDecimal = decimalConvertTempo.format(tempoDouble);

                String kwhString = aparelho.getKwh();
                double kwhDouble = Double.parseDouble(kwhString);
                DecimalFormat decimalConvetKwh = new DecimalFormat("0.00");
                String kwhDecimal = decimalConvetKwh.format(kwhDouble);

                dataAparelho[i] = new String[]{
                        aparelho.getNomeAparelho(),
                        aparelho.getNomeFabricante(),
                        aparelho.getMarca(),
                        aparelho.getModelo(),
                        aparelho.getVolts()+v,
                        aparelho.getWatts()+w,
                        aparelho.getTempo()+h,
                        aparelho.getKwh()
                };
            }
        } else {
            dataAparelho = new String[0][headerAparelho.length];
        }

        // Modelo da tabela
        DefaultTableModel modelAparelho = new DefaultTableModel(dataAparelho, headerAparelho) {
            // Evita que a tabela seja editada
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        getTabelaAparelho().setModel(modelAparelho);

        // Criar a tabela
        getPanelAparelhos().setVisible(false);
        JScrollPane scrollPaneAparelho = new JScrollPane(getTabelaAparelho());
        scrollPaneAparelho.setBounds(25,270,630,222);
        getPanelAparelhos().add(scrollPaneAparelho);

        // Botão para excluir aparelho cadastrado
        getBtnCustoMensal().setVisible(false);
        getBtnCustoMensal().setBounds(50,510,115,28);
        getBtnCustoMensal().setFont(new Font("Arial", Font.BOLD,12));
        getPanelAparelhos().add(getBtnCustoMensal());

        // Botão para excluir aparelho cadastrado
        getBtnExcluirAparelho().setVisible(false);
        getBtnExcluirAparelho().setBounds(490,510,135,28);
        getBtnExcluirAparelho().setFont(new Font("Arial", Font.BOLD,12));
        getPanelAparelhos().add(getBtnExcluirAparelho());
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
        panelClassificacao.setBorder(BorderFactory.createTitledBorder("CLASSIFICAÇÃO"));
        panelClassificacao.setBounds(20,175,309,200);
        getPanelCompanhia().add(panelClassificacao);

        // Labels da tarifa da companhia
        JLabel tarifaTxt = new JLabel("Tarifa de Energia por kWh: R$");
        tarifaTxt.setBounds(370,54,300,20);
        tarifaTxt.setFont(new Font("Arial", Font.BOLD, 14));
        tarifaTxt.setForeground(Color.BLACK);
        getPanelCompanhia().add(tarifaTxt);

        // Field da tarifa da companhia
        getFieldTarifa().setVisible(false);
        getFieldTarifa().setBounds(580,50,62,26);
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
        String[] headerCompanhia = {"Nome", "CNPJ", "Telefone", "Fornecimento", "Medidor", "Tarifa"};

        String[][] dataCompanhia = new String[companhiasUsuario.size()][headerCompanhia.length];

            if (!companhiasUsuario.isEmpty()) {
                for (int i = 0; i < companhiasUsuario.size(); i++) {
                    Companhia companhia = companhiasUsuario.get(i);
                    String rs = "R$ ";
                    String tarifaString = companhia.getTarifa();
                    double tarifaDouble = Double.parseDouble(tarifaString);
                    DecimalFormat decimal = new DecimalFormat("#0.00");
                    String tarifaDecimal = decimal.format(tarifaDouble);
                    dataCompanhia[i] = new String[]{
                            companhia.getNomeCompanhia(),
                            companhia.getCnpj(),
                            companhia.getTelefoneCompanhia(),
                            companhia.getTipoFornecimento(),
                            companhia.getMedidor(),
                            rs+tarifaDecimal,
                    };
                }
            } else {
                dataCompanhia = new String[0][headerCompanhia.length];
            }

        // Modelo da tabela
        DefaultTableModel modelCompanhia = new DefaultTableModel(dataCompanhia, headerCompanhia) {
            // Evita que a tabela seja editada
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        getTabelaCompanhia().setModel(modelCompanhia);

        // Criar a tabela
        getPanelCompanhia().setVisible(false);
        JScrollPane scrollPane = new JScrollPane(getTabelaCompanhia());
        scrollPane.setBounds(25,400,630,100);
        getPanelCompanhia().add(scrollPane);

        // Botão para excluir companhia cadastrada
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

        // lista de endereco do usuario
        List<Endereco> enderecoUsuario = enderecoDAO.buscarEndereco(usuario.getId());

        // Labels que pega o endereço do usuario da tabela de endereço atual
        if (!enderecoUsuario.isEmpty()) {
            for (int i = 0; i < enderecoUsuario.size(); i++) {
                Endereco enderecoAtual = enderecoUsuario.get(i);

                getCepbd().setText(enderecoAtual.getCep());
                getCepbd().setBounds(425, 53, 200, 20);
                getCepbd().setFont(new Font("Calibri", Font.PLAIN, 16));
                getPanelCadastro().add(getCepbd());

                getRuabd().setText(enderecoAtual.getRua());
                getRuabd().setBounds(425, 78, 200, 20);
                getRuabd().setFont(new Font("Calibri", Font.PLAIN, 16));
                getPanelCadastro().add(getRuabd());

                getNumerobd().setText(enderecoAtual.getNumero());
                getNumerobd().setBounds(450, 102, 200, 20);
                getNumerobd().setFont(new Font("Calibri", Font.PLAIN, 16));
                getPanelCadastro().add(getNumerobd());

                getBairrobd().setText(enderecoAtual.getBairro());
                getBairrobd().setBounds(440, 128, 200, 20);
                getBairrobd().setFont(new Font("Calibri", Font.PLAIN, 16));
                getPanelCadastro().add(getBairrobd());

                getCidadebd().setText(enderecoAtual.getCidade());
                getCidadebd().setBounds(445, 153, 200, 20);
                getCidadebd().setFont(new Font("Calibri", Font.PLAIN, 16));
                getPanelCadastro().add(getCidadebd());

                getEstadobd().setText(enderecoAtual.getEstado());
                getEstadobd().setBounds(445, 178, 200, 20);
                getEstadobd().setFont(new Font("Calibri", Font.PLAIN, 16));
                getPanelCadastro().add(getEstadobd());
            }
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

        // Icones das opções de menu
        ImageIcon iconPersonagem = new ImageIcon(Main.class.getResource("/application/view/icons/personagem.png"));
        getIconPersonagem().setIcon(iconPersonagem);
        getIconPersonagem().setBounds(5,140,241,400);
        getIconPersonagem().setVisible(true);
        getPanelAjuda().add(getIconPersonagem());

        ImageIcon iconChat = new ImageIcon(Main.class.getResource("/application/view/icons/chat.png"));
        getIconChat().setIcon(iconChat);
        getIconChat().setBounds(140,-140,512,512);
        getIconChat().setVisible(true);
        getPanelAjuda().add(getIconChat());

        ImageIcon iconGithub = new ImageIcon(Main.class.getResource("/application/view/icons/github.png"));
        getIconGithub().setIcon(iconGithub);
        getIconGithub().setBounds(640,513,25,25);
        getIconGithub().setVisible(true);
        getPanelAjuda().add(getIconGithub());

        // - TEXTOS DO PAINEL DE DETALHES -
        JLabel txtCalculoKwhTitulo = new JLabel("Calculo do Consumo em kWh:");
        txtCalculoKwhTitulo.setBounds(375,38,200,10);
        txtCalculoKwhTitulo.setFont(new Font("Arial",Font.BOLD,12));
        txtCalculoKwhTitulo.setForeground(Color.BLUE);
        getPanelAjuda().add(txtCalculoKwhTitulo);

        String txtCalculoInfo = "<html>- O consumo de energia é calculado em kilowatt-hora (kWh).<br>" +
                "- Fórmula: (Watts x Tempo de Uso Diário (Horas) / 1000)<br>" +
                "<br>Exemplo:<br>" +
                "- Potência do Aparelho: 1000W<br>" +
                "- Tempo de Uso Diário: 30 minutos (0.5 horas)<br><br>" +
                "Consumo Diário (kWh) = 1000W × 0.5h / 1000<br>" +
                "Consumo Diário (kWh) = 0.5kWh</html>";

        JLabel txtCalculo = new JLabel();
        txtCalculo.setText(txtCalculoInfo);
        txtCalculo.setBounds(373,35,400,150);
        txtCalculo.setFont(new Font("Arial",Font.BOLD,10));
        txtCalculo.setForeground(Color.BLACK);
        getPanelAjuda().add(txtCalculo);

        JLabel txtCalculoMensalTitulo = new JLabel("Calculo do Custo Mensal:");
        txtCalculoMensalTitulo.setBounds(375,182,200,10);
        txtCalculoMensalTitulo.setFont(new Font("Arial",Font.BOLD,12));
        txtCalculoMensalTitulo.setForeground(Color.BLUE);
        getPanelAjuda().add(txtCalculoMensalTitulo);

        String txtCustoInfo = "<html>- Informe a tarifa de energia cobrada pela sua fornecedora <br>(em R$/kWh).<br>" +
                "- É multiplicado o consumo mensal total de todos os <br>aparelho em kWh pela tarifa de energia.<br>" +
                "- Fórmula: (Consumo Mensal em kWh) x (Tarifa de Energia)<br><br>" +
                "Exemplo:<br>" +
                "Supondo que a tarifa de energia seja R$0,60 por kWh.<br>" +
                "- Custo Total Mensal (R$) = kWh × Tarifa de Energia<br>" +
                "- Custo Total Mensal (R$) = 15kWh × R$0,60/kWh<br>" +
                "- Custo Total Mensal (R$) = R$9,00<br><br>" +
                "OBS: Importante destacar que o Custo Mensal calculado<br>" +
                "pelo nosso aplicativo, calcula todos os aparelhos.<br>" +
                "Consumo Mensal dos Aparelhos (kWh) × Tarifa de energia</html>";

        JLabel txtCusto = new JLabel();
        txtCusto.setText(txtCustoInfo);
        txtCusto.setBounds(373,196,400,200);
        txtCusto.setFont(new Font("Arial",Font.BOLD,10));
        txtCusto.setForeground(Color.BLACK);
        getPanelAjuda().add(txtCusto);

        JLabel txtCompanhiaTitulo = new JLabel("Especificações da Companhia:");
        txtCompanhiaTitulo.setBounds(375,408,300,10);
        txtCompanhiaTitulo.setFont(new Font("Arial",Font.BOLD,12));
        txtCompanhiaTitulo.setForeground(Color.BLUE);
        getPanelAjuda().add(txtCompanhiaTitulo);

        String txtCompanhiaInfo = "<html>É possivel cadastrar mais de uma Companhia e<br>" +
                "escolher qual Companhia fazer o calculo do Custo Mensal.<br>" +
                "Cada distribuidora terá suas Tarifas e Encargos cobrados.<br>" +
                "Você pode ver as especificações para o cadastro da<br>" +
                "Companhia na sua Conta de Luz.</html>";

        JLabel txtEspecificacao = new JLabel();
        txtEspecificacao.setText(txtCompanhiaInfo);
        txtEspecificacao.setBounds(373,356,400,200);
        txtEspecificacao.setFont(new Font("Arial",Font.BOLD,10));
        txtEspecificacao.setForeground(Color.BLACK);
        getPanelAjuda().add(txtEspecificacao);

        // - PAINEL DE DETALHES -
        JPanel panelDetalhesAparelhos = new JPanel();
        panelDetalhesAparelhos.setBorder(BorderFactory.createTitledBorder("CONSUMO / CUSTO / CALCULOS"));
        panelDetalhesAparelhos.setBounds(364,15,310,490);
        getPanelAjuda().add(panelDetalhesAparelhos);

        // -------------------------------------------FIM AJUDA----------------------------------------------------- //

        // Apenas um panel de fundo
        JPanel panelFundo = new JPanel();
        getFrameMenu().add(panelFundo);

        // Iniciando
        getFrameMenu().setVisible(true); // frameM de menu visivel
        JOptionPane.showMessageDialog(null, "Seja bem-vindo ao Controle de Energia!");
    }
}
