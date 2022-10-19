package com.coder.model;
// Generated Jan 23, 2021 7:50:44 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * MemberStatus generated by hbm2java
 */
@Entity
@Table(name = "member_status", catalog = "drnineni_paint_shop")
public class MemberStatus implements java.io.Serializable {

	private Integer memberStatusId;
	private String statusName;
	private String statusDesc;
	private Set<Member> members = new HashSet<Member>(0);

	public MemberStatus() {
	}

	public MemberStatus(String statusName) {
		this.statusName = statusName;
	}

	public MemberStatus(String statusName, String statusDesc, Set<Member> members) {
		this.statusName = statusName;
		this.statusDesc = statusDesc;
		this.members = members;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "member_status_id", unique = true, nullable = false)
	public Integer getMemberStatusId() {
		return this.memberStatusId;
	}

	public void setMemberStatusId(Integer memberStatusId) {
		this.memberStatusId = memberStatusId;
	}

	@Column(name = "status_name", nullable = false, length = 1500)
	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Column(name = "status_desc", length = 1500)
	public String getStatusDesc() {
		return this.statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "memberStatus")
	public Set<Member> getMembers() {
		return this.members;
	}

	public void setMembers(Set<Member> members) {
		this.members = members;
	}

}