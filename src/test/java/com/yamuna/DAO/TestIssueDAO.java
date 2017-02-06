package com.yamuna.DAO;



	import java.util.Iterator;
	import java.util.List;

	import com.yamuna.model.Department;
	import com.yamuna.model.Issue;
	import com.yamuna.model.UserInfo;


	public class TestIssueDAO {

		public static void main(String[] args) {
			Issue issue=new Issue();
			IssueDAO issueDao=new IssueDAO();
			UserInfo userinfo=new UserInfo();
			userinfo.setId(2);
			issue.setUSER_ID(userinfo);
			
			Department department=new Department();
			department.setId(1);
			issue.setDEPARTMENT_ID(department);
			
			//issue.setSUBJECT("LOGIN FAULT");
			//issue.setDESCRIPTION("TOUCH DOESNT WORK");
			//issue.setPRIORITY("MEDIUM");
			
			issueDao.save(issue);
			List<Issue> list = issueDao.findAll();
			Iterator<Issue> i = list.iterator();
			while (i.hasNext()) {
				Issue issues = (Issue) i.next();
				System.out.println(issues.getId()+"\t"+issues.getUSER_ID().getId()+"\t"+issues.getDEPARTMENT_ID().getId()
						+"\t"+issues.getSUBJECT()+"\t"+issues.getDESCRIPTION()+"\t"+issues.getCREATED_DATE()+"\t"
						+issues.getRESOLVED_DATE()+"\t"+issues.getSTATUS());
			}
			//System.out.println(issueDao.findStatus(2, 3).getSTATUS());
		}

	}

