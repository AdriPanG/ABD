/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import abd.p1.controller.UserController;
import abd.p1.model.Contacto;
import abd.p1.model.Genero;
import abd.p1.model.MensajeAmistad;
import abd.p1.model.Usuario;

/**
 *
 * @author adrianpanaderogonzalez
 */
public class UserPanel extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre = "pepe";
    private int edad = 32;
    private boolean editable = true;
    private Usuario uCambio;
    private Usuario u;
    private Usuario uSesion;
    private UserController control;
    private DefaultListModel<String> modelo;
    private boolean cambioAficiones;
    private boolean cambioDescripciones;

	/**
     * Creates new form UserPanel
     */
    public UserPanel(Usuario u, boolean miPerfil, UserController c, Usuario uSesion) {
    	cambioAficiones = false;
    	cambioDescripciones = false;
    	this.u = u;
    	this.uSesion = uSesion;
    	this.control = c;
    	uCambio = new Usuario();
        initComponents(u, u.getAficiones());
        if(!miPerfil){
        	desactivarBotones();
        }
        labelNombre.setText(u.getNombre());
        if(u.getFecha_nacimiento() != null)
        labelEdad.setText(u.getEdad() + " años");
        
        if(u.getImagen() != null)
        	avatarPanel1.setIcon(new ImageIcon(u.getImagen()));
    }

    private void desactivarBotones() {
		buttonAnadirAficion.setVisible(false);
		buttonEditarAficion.setVisible(false);
        buttonEliminarAficion.setVisible(false);
		buttonCancelar.setVisible(false);
		buttonAvatar.setVisible(false);
		buttonFechaNacimiento.setVisible(false);
		buttonGuardar.setVisible(false);
		buttonNombre.setVisible(false);
		buttonPassword.setVisible(false);
		buttonPreferencia.setVisible(false);
		buttonSexo.setVisible(false);
		jTextArea1.setEnabled(false);
		listaAficiones.setPreferredSize(new Dimension(300,500));
        listaAficiones.setEnabled(false);
		
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        labelNombre.setText(nombre);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
        labelEdad.setText(edad + " años");
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        buttonNombre.setVisible(editable);
        buttonFechaNacimiento.setVisible(editable);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @param aficiones 
     * @param u2 
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(Usuario u2, List<String> aficiones) {

        avatarPanel1 = new abd.p1.view.AvatarPanel();
        labelNombre = new javax.swing.JLabel();
        labelEdad = new javax.swing.JLabel();
        buttonNombre = new javax.swing.JButton();
        buttonFechaNacimiento = new javax.swing.JButton();
        buttonAvatar = new javax.swing.JButton();
        labelDescripcion = new javax.swing.JLabel();
        scrollDescripcion = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        labelAficiones = new javax.swing.JLabel();
        scrollAficiones = new javax.swing.JScrollPane();
        listaAficiones = new javax.swing.JList<>();
        buttonAnadirAficion = new javax.swing.JButton();
        buttonEliminarAficion = new javax.swing.JButton();
        buttonEditarAficion = new javax.swing.JButton();
        buttonSexo = new javax.swing.JButton();
        buttonPreferencia = new javax.swing.JButton();
        labelSexo = new javax.swing.JLabel();
        labelSexoGenero = new javax.swing.JLabel();
        labelBusca = new javax.swing.JLabel();
        labelBuscaGenero = new javax.swing.JLabel();
        buttonCancelar = new javax.swing.JButton();
        buttonGuardar = new javax.swing.JButton();
        buttonPassword = new javax.swing.JButton();

        avatarPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout avatarPanel1Layout = new javax.swing.GroupLayout(avatarPanel1);
        avatarPanel1.setLayout(avatarPanel1Layout);
        avatarPanel1Layout.setHorizontalGroup(
            avatarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        avatarPanel1Layout.setVerticalGroup(
            avatarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        labelNombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(51, 51, 51));
        labelNombre.setText("Nombre");

        labelEdad.setForeground(new java.awt.Color(51, 51, 51));
        labelEdad.setText("Edad");

        buttonNombre.setText("Cambiar nombre");
        buttonNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNombreActionPerformed(evt);
            }
        });
        
        buttonFechaNacimiento.setText("Cambiar fecha de nacimiento");
        buttonFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFechaNacimientoActionPerformed(evt);
            }
        });
        
        buttonAvatar.setText("Cambiar avatar");
        buttonAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAvatarActionPerformed(evt);
            }
        });
        
        labelDescripcion.setText("Descripción:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText(u.getDescripcion());
        scrollDescripcion.setViewportView(jTextArea1);
        jTextArea1.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				cambioDescripciones = true;
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				cambioDescripciones = true;
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				cambioDescripciones = true;
			}
		});
        

        labelAficiones.setText("Aficiones:");

        modelo = new DefaultListModel<String>();
        listaAficiones.setModel(modelo);
        if(aficiones != null && aficiones.size() != -1){
	        for(String s: aficiones){
	        	modelo.addElement(s);
	        }
        }
        scrollAficiones.setViewportView(listaAficiones);

        buttonAnadirAficion.setText("Añadir afición");
        buttonAnadirAficion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnadirAficionActionPerformed(evt);
            }

        });

        buttonEliminarAficion.setText("Eliminar seleccionada");
        buttonEliminarAficion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarAficionActionPerformed1(evt);
            }
        });

        buttonEditarAficion.setText("Editar seleccionada");
        buttonEditarAficion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarAficionActionPerformed(evt);
            }
        });

        buttonSexo.setText("Cambiar sexo");
        buttonSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSexoActionPerformed(evt);
            }
        });

        buttonPreferencia.setText("Cambiar preferencia");
        buttonPreferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPreferenciaActionPerformed(evt);
            }
        });
        
        labelSexo.setText("Sexo:");
        if(u.getGenero() != null)
        labelSexoGenero.setText(u.getGenero().toString());

        labelBusca.setText("Busca:");
        if(u.getContacto() != null)
        labelBuscaGenero.setText(u.getContacto().toString());

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        buttonGuardar.setText("Guardar cambios");
        buttonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGuardarActionPerformed(evt);
            }
        });

        buttonPassword.setText("Cambiar contraseña");
        buttonPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollAficiones)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonEditarAficion, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonEliminarAficion, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAnadirAficion, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollDescripcion)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelDescripcion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buttonFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(avatarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelEdad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(buttonPassword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                                .addComponent(buttonGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonCancelar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelBusca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelBuscaGenero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buttonSexo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonPreferencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelSexo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelSexoGenero))
                                    .addComponent(labelAficiones))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonNombre)
                    .addComponent(avatarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonFechaNacimiento)
                    .addComponent(labelDescripcion))
                .addGap(4, 4, 4)
                .addComponent(buttonAvatar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelAficiones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollAficiones, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(buttonAnadirAficion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonEliminarAficion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEditarAficion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSexo)
                    .addComponent(labelSexoGenero)
                    .addComponent(buttonSexo))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBusca)
                    .addComponent(labelBuscaGenero)
                    .addComponent(buttonPreferencia))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancelar)
                    .addComponent(buttonGuardar)
                    .addComponent(buttonPassword))
                .addContainerGap())
        );
        if(u.getImagen() != null)
        	 avatarPanel1.setIcon(new ImageIcon(u.getImagen()));
    }// </editor-fold>//GEN-END:initComponents

    protected void buttonNombreActionPerformed(ActionEvent evt) {
    	String cambioNombre = CambioUsuario.createCambioUsuario(null, true,"nombre", false, "");
    	if(cambioNombre != null) {
    		labelNombre.setText(cambioNombre);
    		uCambio.setNombre(labelNombre.getText());
    	}
	}

	protected void buttonFechaNacimientoActionPerformed(ActionEvent evt) {
		Date d = CambioUsuarioFecha.createCambioFecha(null, true);
		if(d != null){
			uCambio.setFecha_nacimiento(d);
			labelEdad.setText(new Integer(uCambio.getEdad()).toString() + " años");
		}
	}

	protected void buttonAvatarActionPerformed(ActionEvent evt) {
		CambioAvatar cA = new CambioAvatar(null, true);
		byte[] avatar = cA.getAvatar();
		if(avatar != null){
			avatarPanel1.setIcon(new ImageIcon(avatar));
			uCambio.setImagen(avatar);
		}
		
	}

	protected void buttonSexoActionPerformed(ActionEvent evt) {
		List<String> lista = new ArrayList<String>();
		for(Genero g: Genero.values())
			lista.add(g.toString());
		String seleccion = CambiarComboBox.createCambioComboBox(null, true, "genero", lista);
		if(seleccion != null){
			labelSexoGenero.setText(seleccion);
			uCambio.setGenero(Genero.valueOf(seleccion));
		}
	}

	protected void buttonPreferenciaActionPerformed(ActionEvent evt) {
		List<String> lista = new ArrayList<String>();
		for(Contacto g: Contacto.values())
			lista.add(g.toString());
		String seleccion = CambiarComboBox.createCambioComboBox(null, true, "preferencia", lista);
		if(seleccion != null){
			labelBuscaGenero.setText(seleccion);
			uCambio.setContacto(Contacto.valueOf(seleccion));
		}
	}

	protected void buttonCancelarActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}

	private void buttonAnadirAficionActionPerformed(ActionEvent evt) {
    	modelo.addElement(CambioUsuario.createCambioUsuario(null, true,"aficion", false, ""));
    	cambioAficiones = true;
	}
	
	protected void buttonEliminarAficionActionPerformed1(ActionEvent evt) {
		int pos = listaAficiones.getSelectedIndex();
		if (pos != -1) {
			modelo.remove(pos);
			cambioAficiones = true;
		} else {
			JOptionPane.showMessageDialog(null, "Debes seleccionar una afición", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void buttonEditarAficionActionPerformed(java.awt.event.ActionEvent evt) {
		int pos = listaAficiones.getSelectedIndex();
		if (pos != -1) {
			String aficion = CambioUsuario.createCambioUsuario(null, true,"aficion", true, listaAficiones.getSelectedValue());
			modelo.set(pos, aficion);
			cambioAficiones = true;
		} else {
			JOptionPane.showMessageDialog(null, "Debes seleccionar una afición", "Error", JOptionPane.ERROR_MESSAGE);
		}
    }

    private void buttonGuardarActionPerformed(java.awt.event.ActionEvent evt) {
    	if(cambioAficiones){
    		List<String> lista = new ArrayList<String>();
    		for(int i = 0; i < listaAficiones.getModel().getSize(); i++)
    			lista.add(listaAficiones.getModel().getElementAt(i));
    		uCambio.setAficiones(lista);
    	}
    	if(cambioDescripciones) {
    		uCambio.setDescripcion(jTextArea1.getText());
    	}
        control.updateUser(u.getEmail(), uCambio);
    }



	private void buttonPasswordActionPerformed(java.awt.event.ActionEvent evt) {
        uCambio.setPassword(CambioPassword.createCambioPassword(null, true, u.getPassword()));
    }
	
	private void addFriend(){
		u.addAmigo(uSesion);
		uSesion.addAmigo(u);
		control.nuevoMensajeAmistad(new MensajeAmistad(uSesion, u));
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
    private abd.p1.view.AvatarPanel avatarPanel1;
    private javax.swing.JButton buttonAnadirAficion;
    private javax.swing.JButton buttonAvatar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonEditarAficion;
    private javax.swing.JButton buttonEliminarAficion;
    private javax.swing.JButton buttonFechaNacimiento;
    private javax.swing.JButton buttonGuardar;
    private javax.swing.JButton buttonNombre;
    private javax.swing.JButton buttonPassword;
    private javax.swing.JButton buttonPreferencia;
    private javax.swing.JButton buttonSexo;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelAficiones;
    private javax.swing.JLabel labelBusca;
    private javax.swing.JLabel labelBuscaGenero;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelEdad;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelSexo;
    private javax.swing.JLabel labelSexoGenero;
    private javax.swing.JList<String> listaAficiones;
    private javax.swing.JScrollPane scrollAficiones;
    private javax.swing.JScrollPane scrollDescripcion;
    // End of variables declaration//GEN-END:variables

}