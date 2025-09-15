package viewer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class HelperTableModel {
	private DefaultTableModel  tableModel;
	private ArrayList<String>  listaAtributos = new ArrayList<String>();
	private Object[][] tabela; 
	
	public HelperTableModel(Object[] objetos) {
		if(objetos == null || objetos.length == 0 || objetos[0] == null)
			return;
		Class classe = objetos[0].getClass();
		for(Method m : classe.getMethods()) {
			String nomeMetodo = m.getName();
			if(nomeMetodo.startsWith("get") && !nomeMetodo.equals("getClass") ) 				
				listaAtributos.add(nomeMetodo.substring(3));
		}
		// Contando quantos objetos diferentes de null temos no array de objetos
		int qtde = 0;
		for(; qtde < objetos.length; qtde++)
			if(objetos[qtde] == null)
				break;
				
		tabela = new Object[qtde][listaAtributos.size()];
		for(int i = 0; i < qtde; i++) {
			for(int j = 0; j < listaAtributos.size(); j++) {
				try {
					Method get = classe.getMethod("get"+ listaAtributos.get(j));
					Object valor = get.invoke(objetos[i]);
					tabela[i][j] = valor;
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		this.tableModel = new DefaultTableModel(this.getTabela(), this.getAtributos());
	}

	public Object[] getAtributos() {
		return listaAtributos.toArray();
	}
	
	public Object[][] getTabela() {
		return this.tabela;
	}
	
	public DefaultTableModel getTableModel() {
		return this.tableModel;
	}
}