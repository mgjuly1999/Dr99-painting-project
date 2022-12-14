package com.coder.model;
// Generated Jan 23, 2021 7:50:44 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ToolLanguage generated by hbm2java
 */
@Entity
@Table(name = "tool_language", catalog = "drnineni_paint_shop")
public class ToolLanguage implements java.io.Serializable {

	private ToolLanguageId id;
	private FreeTool freeTool;
	private Language language;
	private String toolName;
	private String toolDescription;

	public ToolLanguage() {
	}

	public ToolLanguage(ToolLanguageId id, FreeTool freeTool, Language language) {
		this.id = id;
		this.freeTool = freeTool;
		this.language = language;
	}

	public ToolLanguage(ToolLanguageId id, FreeTool freeTool, Language language, String toolName,
			String toolDescription) {
		this.id = id;
		this.freeTool = freeTool;
		this.language = language;
		this.toolName = toolName;
		this.toolDescription = toolDescription;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "languageId", column = @Column(name = "language_id", nullable = false)),
			@AttributeOverride(name = "toolId", column = @Column(name = "tool_id", nullable = false)) })
	public ToolLanguageId getId() {
		return this.id;
	}

	public void setId(ToolLanguageId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tool_id", nullable = false, insertable = false, updatable = false)
	public FreeTool getFreeTool() {
		return this.freeTool;
	}

	public void setFreeTool(FreeTool freeTool) {
		this.freeTool = freeTool;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "language_id", nullable = false, insertable = false, updatable = false)
	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	@Column(name = "tool_name", length = 1500)
	public String getToolName() {
		return this.toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	@Column(name = "tool_description", length = 1500)
	public String getToolDescription() {
		return this.toolDescription;
	}

	public void setToolDescription(String toolDescription) {
		this.toolDescription = toolDescription;
	}

}
