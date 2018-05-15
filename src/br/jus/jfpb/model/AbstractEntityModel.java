package br.jus.jfpb.model;

public abstract class AbstractEntityModel {
	
	public abstract Long getId();
	public abstract void setId(Long id);
	
	@Override
	public boolean equals(Object obj) {
		AbstractEntityModel entidade = (AbstractEntityModel)  obj;
		if(this.temIdValido() && entidade.temIdValido() && this.getId().equals(entidade.getId())){
			return true;
		}
		return false;
	}
	
	public boolean temIdValido(){
		return getId() != null && getId() != 0;
	}
}

//Desenvolvido por Yuri Santos
