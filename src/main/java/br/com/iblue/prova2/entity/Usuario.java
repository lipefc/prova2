package br.com.iblue.prova2.entity;

	import java.io.Serializable;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.SequenceGenerator;
	import javax.persistence.Table;
	import javax.validation.constraints.Max;
	import javax.validation.constraints.Min;
	import com.fasterxml.jackson.annotation.JsonProperty;

	@Entity
	@Table(name = "tblusuario")
	@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", initialValue = 1, allocationSize = 1)
	public class Usuario implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(generator = "seq_usuario")
		@JsonProperty("id-usuario")
		@Column(name = "idusuario")
		private Long idUsuario;

		@JsonProperty("uuid")
		@Column(name = "uuid")
		private String uuid;

		@JsonProperty("nome")
		@Column(name = "nome")
		private String nome;

		@JsonProperty("email")
		@Column(name = "email")
		private String email;

		@JsonProperty("senha")
		@Column(name = "senha")
		private String senha;

		@Min(value=0,message="Nota1 maior que 0")
		@Max(value=10,message="Nota1 menor que 10")
		@Column(name="nota1")
		@JsonProperty("nota1")
		private Double nota1;
		
		@Min(value=0,message="Nota2 maior que 0")
		@Max(value=10,message="Nota2 menor que 10")
		@Column(name="nota2")
		@JsonProperty("nota2")
		private Double nota2;
		
		@Min(value=0,message="Nota3 maior que 0")
		@Max(value=10,message="Nota3 menor que 10")
		@Column(name="nota3")
		@JsonProperty("nota3")
		private Double nota3;
		
		@Column(name="situacao")
		@JsonProperty("situacao")
		private String situacao;
		
		@Column(name="media")
		@JsonProperty("media")
		private Double media;
		
		public Usuario() {
		}

		public Usuario(Long idUsuario, String uuid, String nome, String email, String senha,
				@Min(value = 0, message = "Nota1 maior que 0") @Max(value = 10, message = "Nota1 menor que 10") Double nota1,
				@Min(value = 0, message = "Nota2 maior que 0") @Max(value = 10, message = "Nota2 menor que 10") Double nota2,
				@Min(value = 0, message = "Nota3 maior que 0") @Max(value = 10, message = "Nota3 menor que 10") Double nota3,
				String situacao, Double media) {
			super();
			this.idUsuario = idUsuario;
			this.uuid = uuid;
			this.nome = nome;
			this.email = email;
			this.senha = senha;
			this.nota1 = nota1;
			this.nota2 = nota2;
			this.nota2 = nota3;
		}

		public Usuario(String email, String senha) {
			super();
			this.email = email;
			this.senha = senha;
		}

		@Override
		public String toString() {
			return "Usuario [idUsuario=" + idUsuario + ", uuid=" + uuid + ", nome=" + nome + ", email=" + email
					+ ", senha=" + senha + ", nota1=" + nota1 + ", nota2=" + nota2 + ", nota3=" + nota3 + ", situacao="
					+ situacao + ", media=" + media + "]";
		}

		public Long getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(Long idUsuario) {
			this.idUsuario = idUsuario;
		}

		public String getUuid() {
			return uuid;
		}

		public void setUuid(String uuid) {
			this.uuid = uuid;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public Double getNota1() {
			return nota1;
		}

		public void setNota1(Double nota1) {
			this.nota1 = nota1;
		}

		public Double getNota2() {
			return nota2;
		}

		public void setNota2(Double nota2) {
			this.nota2 = nota2;
		}

		public Double getNota3() {
			return nota3;
		}

		public void setNota3(Double nota3) {
			this.nota3 = nota3;
		}

		public String getSituacao() {
			return situacao;
		}

		public void setSituacao(String situacao) {
			this.situacao = situacao;
		}

		public Double getMedia() {
			return media;
		}

		public void setMedia(Double media) {
			this.media = media;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
}