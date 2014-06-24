package com.mycompany.example.client.tokens;

import com.google.gwt.user.client.ui.Button;

public class TokenField extends Button {
	
	public enum Color{
		BLUE("blue"),
		RED("red"),
		ORANGE("orange"),
		GREEN("green");
		
		private String style;
		private Color(String style){
			this.style = style;
		}
		
		public String getStyle(){
			return style;
		}
	}
	
	protected Color color;
	protected String content;
	public TokenField(String content, Color color){
		this.color = color;
		this.content = content;
		setText(content);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenField other = (TokenField) obj;
		if (color != other.color)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		return true;
	}

	
	
}
