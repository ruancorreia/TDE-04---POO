package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CtrlPrograma;

public class JanelaPrincipal extends JanelaAbstrata {

	//
	// ATRIBUTOS
	//
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal(CtrlPrograma ctrl) {
		// O viewer guarda sempre quem é o seu controlador
		// pois todos os eventos são notificados a ele
		super(ctrl);
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 529, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);		
		contentPane.setLayout(null);
		
		JButton btDepartamento = new JButton("Manter Departamentos");
		btDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				// Notifica ao controlador
				ctrl.iniciarManterDepartamentos();
			}
		});
		btDepartamento.setBounds(33, 53, 119, 66);
		contentPane.add(btDepartamento);
		
		JButton btFechar = new JButton("Fechar");
		btFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.encerrar();
			}
		});
		btFechar.setBounds(366, 53, 119, 66);
		contentPane.add(btFechar);
		
		JButton btEmpregado = new JButton("Incluir Empregado");
		btEmpregado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarIncluirEmpregado();
			}
		});
		btEmpregado.setBounds(195, 53, 119, 66);
		contentPane.add(btEmpregado);
	}

}
