package application.events;

import application.controller.JanelaMenuControl;
import application.model.DAO.CompanhiaDAO;
import application.model.DAO.EnderecoDAO;
import application.model.DAO.UsuarioDAO;
import application.model.entity.Companhia;
import application.model.entity.Endereco;
import application.model.entity.Usuario;
import application.view.JanelaLoginView;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

// Classe responsável para ações dos objetos interáveis
public class JanelaMenuEvents extends JanelaMenuControl {

    private UsuarioDAO usuarioDAO;
    private EnderecoDAO enderecoDAO;
    private CompanhiaDAO companhiaDAO;
    private Companhia companhia;

    // Eventos dos objetos
    public JanelaMenuEvents() {
        this.usuarioDAO = new UsuarioDAO();
        this.enderecoDAO = new EnderecoDAO();
        this.companhiaDAO = new CompanhiaDAO();
        this.companhia = new Companhia();

        getBtnSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaLoginView janelaLoginView = new JanelaLoginView();
                janelaLoginView.setVisible(true);
                getFrameMenu().dispose();
            }
        });

        // Eventos das telas de opção do menu
        // INICIO
        getBtnInicio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Vizualização dos paineis de menu
                getPanelInicio().setVisible(true);
                getPanelAparelhos().setVisible(false);
                getPanelCompanhia().setVisible(false);
                getPanelCadastro().setVisible(false);
                getPanelAjuda().setVisible(false);

                // Vizualização dos icons
                getIconInicio().setVisible(true);
                getIconAparelhos().setVisible(false);
                getIconCompanhia().setVisible(false);
                getIconCadastro().setVisible(false);
                getIconAjuda().setVisible(false);

                // Limpa os campos de dados que estavam preenchidos
                getFieldNovoNome().setText("");
                getFieldNovoSobrenome().setText("");
                getFieldNovoTelefone().setText("");
                getFieldNovoEmail().setText("");
                getFieldNovoLogin().setText("");
                getFielNovaSenha().setText("");
            }
        });

        // APARELHOS
        getBtnAparelhos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Vizualização dos paineis de menu
                getPanelInicio().setVisible(false);
                getPanelAparelhos().setVisible(true);
                getPanelCompanhia().setVisible(false);
                getPanelCadastro().setVisible(false);
                getPanelAjuda().setVisible(false);

                // Vizualização dos icons
                getIconInicio().setVisible(false);
                getIconAparelhos().setVisible(true);
                getIconCompanhia().setVisible(false);
                getIconCadastro().setVisible(false);
                getIconAjuda().setVisible(false);

                // Limpa os campos de dados que estavam preenchidos
                getFieldNovoNome().setText("");
                getFieldNovoSobrenome().setText("");
                getFieldNovoTelefone().setText("");
                getFieldNovoEmail().setText("");
                getFieldNovoLogin().setText("");
                getFielNovaSenha().setText("");
            }
        });

        // COMPANHIA
        getBtnCompanhia().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Vizualização dos paineis de menu
                getPanelInicio().setVisible(false);
                getPanelAparelhos().setVisible(false);
                getPanelCompanhia().setVisible(true);
                getPanelCadastro().setVisible(false);
                getPanelAjuda().setVisible(false);

                // Vizualização dos icons
                getIconInicio().setVisible(false);
                getIconAparelhos().setVisible(false);
                getIconCompanhia().setVisible(true);
                getIconCadastro().setVisible(false);
                getIconAjuda().setVisible(false);

                // Limpa os campos de dados que estavam preenchidos
                getFieldNovoNome().setText("");
                getFieldNovoSobrenome().setText("");
                getFieldNovoTelefone().setText("");
                getFieldNovoEmail().setText("");
                getFieldNovoLogin().setText("");
                getFielNovaSenha().setText("");

                //Vizualização dos campos de cadastro da companhia
                getFieldNomeCompanhia().setVisible(true);
                getFieldCnpjCompanhia().setVisible(true);
                getFieldTelefoneCompanhia().setVisible(true);
                getCheckGrupoA().setVisible(true);
                getCheckGrupoB().setVisible(true);
                getComboTipoFornecimento().setVisible(true);
                getFieldNumMedidor().setVisible(true);
                getFieldTarifa().setVisible(true);
                getInfoTarifa().setVisible(true);
                getTabelaCompanhia().setVisible(true);
                getCadastrarCompanhia().setVisible(true);
                getBtnExcluirCompanhia().setVisible(true);

                // Grupo A vizualização
                getCheckGrupoA().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        getMediaTensao().setVisible(true);
                        getAltaTensao().setVisible(true);
                        getResidencial().setVisible(false);
                        getRural().setVisible(false);
                        getOutros().setVisible(false);
                    }
                });

                // Grupo B vizualização
                getCheckGrupoB().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        getMediaTensao().setVisible(false);
                        getAltaTensao().setVisible(false);
                        getResidencial().setVisible(true);
                        getRural().setVisible(true);
                        getOutros().setVisible(true);
                    }
                });

                // Método responsável para cadastrar novas companhias
                getCadastrarCompanhia().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Obter usuário logado
                        String usuarioLogado = getLogado().getText();
                        // Obter usuário logado no banco de dados
                        Usuario usuarioAtual = usuarioDAO.buscarUsuario(usuarioLogado);

                        Companhia companhia = new Companhia();

                        // Adiciona os dados da nova companhia
                        Object selecaoFornecimento = getComboTipoFornecimento().getSelectedItem();

                        companhia.setNomeCompanhia(getFieldNomeCompanhia().getText());
                        companhia.setCnpj(getFieldCnpjCompanhia().getText());
                        companhia.setTelefoneCompanhia(getFieldTelefoneCompanhia().getText());
                        companhia.setTipoFornecimento(selecaoFornecimento.toString());
                        companhia.setMedidor(getFieldNumMedidor().getText());
                        companhia.setTarifa(getFieldTarifa().getText());

                        if (new CompanhiaDAO().inserirNovaCompanhia(companhia, usuarioAtual.getId())) {
                            // Limpa os campos de dados que estavam preenchidos
                            getFieldNomeCompanhia().setText("");
                            getFieldCnpjCompanhia().setText("");
                            getFieldTelefoneCompanhia().setText("");
                            getFieldNumMedidor().setText("");
                            getFieldTarifa().setText("");
                            JOptionPane.showMessageDialog(null, "Companhia cadastrada com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                            atualizarLista();
                        }  else {
                        JOptionPane.showMessageDialog(null, "Falha ao cadastrar companhia!\nVerifique se os campos estão vazios \nou se já contém uma companhia com o mesmo CNPJ cadastrado.", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                // Método responsável para excluir companhia
                getBtnExcluirCompanhia().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Seleciona uma linha da tabela de companhia
                        int selecionaLinha = getTabelaCompanhia().getSelectedRow();

                        if (selecionaLinha != -1) {
                            // Obtém o CNPJ da linha selecionada
                            String cnpj = (String) getTabelaCompanhia().getValueAt(selecionaLinha, 1);

                            // Obter usuário logado
                            String usuarioLogado = getLogado().getText();

                            // Obter usuário logado no banco de dados
                            Usuario usuarioAtual = usuarioDAO.buscarUsuario(usuarioLogado);

                            int resposta = JOptionPane.showConfirmDialog(null, "Companhia será apagada, tem certeza que deseja excluir?", "EXCLUIR CONTA", JOptionPane.CANCEL_OPTION);
                            if (resposta == JOptionPane.OK_OPTION) {
                                // Exclui a companhia por CNPJ
                                if (new CompanhiaDAO().excluirCompanhiaCnpj(cnpj, usuarioAtual.getId())) {
                                    atualizarLista();
                                    JOptionPane.showMessageDialog(null, "Companhia excluída com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Falha ao excluir a companhia.", "ERRO", JOptionPane.ERROR_MESSAGE);
                                }
                            }

                        }else {
                            JOptionPane.showMessageDialog(null, "Selecione uma companhia para excluir.", "AVISO", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                });
            }
        });

        // CADASTRO
        getBtnCadastro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Vizualização dos paineis de menu
                getPanelInicio().setVisible(false);
                getPanelAparelhos().setVisible(false);
                getPanelCompanhia().setVisible(false);
                getPanelCadastro().setVisible(true);
                getPanelAjuda().setVisible(false);

                // Vizualização dos icons
                getIconInicio().setVisible(false);
                getIconAparelhos().setVisible(false);
                getIconCompanhia().setVisible(false);
                getIconCadastro().setVisible(true);
                getIconAjuda().setVisible(false);

                //Vizualização dos campos de cadastro
                getFieldNovoNome().setVisible(true);
                getFieldNovoSobrenome().setVisible(true);
                getFieldNovoTelefone().setVisible(true);
                getFieldNovoEmail().setVisible(true);
                getFieldNovoLogin().setVisible(true);
                getFielNovaSenha().setVisible(true);
                getBtnAlterarDados().setVisible(true);
                getBtnAlterarLoginSenha().setVisible(true);
                getBtnExcluirUsuario().setVisible(true);
                getBtnAlterarEndereco().setVisible(true);
                getFieldCEP().setVisible(true);
                getFieldRua().setVisible(true);
                getFieldNumero().setVisible(true);
                getFieldBairro().setVisible(true);
                getFieldCidade().setVisible(true);
                getFieldEstado().setVisible(true);

                // Botão que altera os dados do usuário
                getBtnAlterarDados().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Obter usuário logado
                        String usuarioLogado = getLogado().getText();
                        // Obter usuário logado no banco de dados
                        Usuario usuarioAtual = usuarioDAO.buscarUsuario(usuarioLogado);
                        // resposta recebe a opção do JOption
                        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que quer alterar os dados?", "ALTERAR DADOS", JOptionPane.CANCEL_OPTION);

                        if (resposta == JOptionPane.OK_OPTION) {
                            // Confirmou a alteração em OK
                            // Modificar os dados do usuario existentes
                            usuarioAtual.setNome(getFieldNovoNome().getText());
                            usuarioAtual.setSobrenome(getFieldNovoSobrenome().getText());
                            usuarioAtual.setTelefone(getFieldNovoTelefone().getText());
                            usuarioAtual.setEmail(getFieldNovoEmail().getText());
                            // Chama o método para alterar os dados no banco de dados
                            boolean sucesso = usuarioDAO.alterarDadosUsuario(usuarioAtual);

                            if (sucesso) {
                                // Labels que pega os dados que foram atualizados
                                getNomebd().setText(usuarioAtual.getNome());
                                getSobrenomebd().setText(usuarioAtual.getSobrenome());
                                getTelefonebd().setText(usuarioAtual.getTelefone());
                                getEmailbd().setText(usuarioAtual.getEmail());

                                // Limpa os campos de dados que estavam preenchidos
                                getFieldNovoNome().setText("");
                                getFieldNovoSobrenome().setText("");
                                getFieldNovoTelefone().setText("");
                                getFieldNovoEmail().setText("");
                                JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Falha ao alterar os dados!\nVerifique se os campos estão vazios e tenta novamente.", "ERRO", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                });

                // Botão que exclui a conta inteira do usuario
                getBtnExcluirUsuario().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // VERIFICAÇÃO DO USUARIO NO BANCO DE DADOS
                        String nomeUsuario = getFieldNovoLogin().getText();
                        String senhaUsuario = getFielNovaSenha().getText();

                        try {
                            // Verificar se o usuario existe no banco de dados
                            if (new UsuarioDAO().verificarUsuario(nomeUsuario)) {
                                // O Usuario existe, agora verificar senha
                                Usuario usuario = new UsuarioDAO().buscarUsuario(nomeUsuario);
                                // Obter usuário logado
                                String usuarioLogado = getLogado().getText();

                                if (usuario != null && senhaUsuario.equals(usuario.getSenha()) && usuarioLogado.equals(usuario.getUsuario())) {
                                    // Obter usuário logado no banco de dados
                                    Usuario usuarioAtual = usuarioDAO.buscarUsuario(usuarioLogado);
                                    // resposta recebe a opção do JOption
                                    int resposta = JOptionPane.showConfirmDialog(null, "Todos os seus dados serão apagados.\nTem certeza que quer excluir sua conta?", "EXCLUIR CONTA", JOptionPane.CANCEL_OPTION);

                                    if (resposta == JOptionPane.OK_OPTION) {
                                        // Confirmou a alteração em OK
                                        // Endereço excluido com sucesso, agora exclua o usuário
                                        boolean usuarioExcluido = usuarioDAO.excluirUsuario(usuarioAtual.getId());

                                        if (usuarioExcluido) {
                                            // Usuario excluido com sucesso
                                            JanelaLoginView janelaLoginView = new JanelaLoginView(); // Cria a janela de login
                                            janelaLoginView.setVisible(true); // Seta a visualização da janela de login
                                            getFrameMenu().dispose(); // Fecha frame/janela de menu

                                            // Excluir o endereço
                                            boolean enderecoExcluido = enderecoDAO.excluirEndereco(usuarioAtual.getId());

                                            if (enderecoExcluido) {
                                            }

                                        } else {
                                            // Falha ao exclui usuario
                                            JOptionPane.showMessageDialog(null, "Erro ao excluir usuário.", "ERRO", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else {
                                    // usuario logado e Senha incorreta
                                    JOptionPane.showMessageDialog(null, "Usuário ou Senha incorreta!","ERRO DE LOGIN", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                // usuario não econtrado
                                JOptionPane.showMessageDialog(null, "Usuário não encontrado!","ERRO DE LOGIN",JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace(); // Tratando a exceção
                        }
                    }
                });

                // Botão que altera o endereço do usuari do usuário
                getBtnAlterarEndereco().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Obter usuário logado
                        String usuarioLogado = getLogado().getText();
                        // Obter usuário logado no banco de dados
                        Usuario usuarioAtual = usuarioDAO.buscarUsuario(usuarioLogado);

                        Endereco endereco = new Endereco();

                        // Obter os dados do formulario
                        endereco.setCep(getFieldCEP().getText());
                        endereco.setRua(getFieldRua().getText());
                        endereco.setNumero(getFieldNumero().getText());
                        endereco.setBairro(getFieldBairro().getText());
                        endereco.setCidade(getFieldCidade().getText());
                        endereco.setEstado(getFieldEstado().getText());

                        // Inserir no banco de dados
                        if (new EnderecoDAO().inserirEndereco(endereco, usuarioAtual.getId())) {
                            // Labels que pega os dados que foram atualizados
                            getCepbd().setText(endereco.getCep());
                            getRuabd().setText(endereco.getRua());
                            getNumerobd().setText(endereco.getNumero());
                            getBairrobd().setText(endereco.getBairro());
                            getCidadebd().setText(endereco.getCidade());
                            getEstadobd().setText(endereco.getEstado());

                            // Limpa os campos de dados que estavam preenchidos
                            getFieldCEP().setText("");
                            getFieldRua().setText("");
                            getFieldNumero().setText("");
                            getFieldBairro().setText("");
                            getFieldCidade().setText("");
                            getFieldEstado().setText("");
                            // Cadastro efetuado com sucesso
                            JOptionPane.showMessageDialog(null, "Endereço atualizado com sucesso!\nSe for a primeira atualização do endereço, faça o login novamente para a atualização do sistema, obrigado!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Falha ao alterar o endereço!\nVerifique se os campos estão vazios e tenta novamente.", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
            }
        });

        // AJUDA
        getBtnAjuda().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Vizualização dos paineis de menu
                getPanelInicio().setVisible(false);
                getPanelAparelhos().setVisible(false);
                getPanelCompanhia().setVisible(false);
                getPanelCadastro().setVisible(false);
                getPanelAjuda().setVisible(true);

                // Vizualização dos icons
                getIconInicio().setVisible(false);
                getIconAparelhos().setVisible(false);
                getIconCompanhia().setVisible(false);
                getIconCadastro().setVisible(false);
                getIconAjuda().setVisible(true);

                // Limpa os campos de dados que estavam preenchidos
                getFieldNovoNome().setText("");
                getFieldNovoSobrenome().setText("");
                getFieldNovoTelefone().setText("");
                getFieldNovoEmail().setText("");
                getFieldNovoLogin().setText("");
                getFielNovaSenha().setText("");
            }
        });
    }

    // Método para atualizar a lista de companhia
    public void atualizarLista() {
        String usuarioLogado = getLogado().getText();
        Usuario usuarioAtual = usuarioDAO.buscarUsuario(usuarioLogado);
        List<Companhia> companhias  = companhiaDAO.buscarCompanhias(usuarioAtual.getId());
        atualizarTabelaCompanhias(companhias); // Pega a atualização da tabela para atualizar a lista de companhia
    }

    // Método para atualizar a tabela de companhia vizual
    private void atualizarTabelaCompanhias(List<Companhia> companhias) {
        DefaultTableModel model = (DefaultTableModel) getTabelaCompanhia().getModel();
        model.setRowCount(0);
        for (Companhia companhia : companhias) {
            Object[] row = {
                    companhia.getNomeCompanhia(),
                    companhia.getCnpj(),
                    companhia.getTelefoneCompanhia(),
                    companhia.getTipoFornecimento(),
                    companhia.getMedidor(),
                    companhia.getTarifa()
            };
            model.addRow(row);
        }
    }
}
