package com.yamuna.DAO;



	import com.yamuna.model.Issue;
	import com.yamuna.model.UserInfo;


	public class TestIssueDAO {

		public static void main(String[] args) {
			Issue issue=new Issue();
			IssueDAO issueDao=new IssueDAO();
			UserInfo userinfo=new UserInfo();
			userinfo.setId(1);
			
			issue.setUSER_ID(userinfo);
			issue.setId(1);
			int issueid=issue.getId();
			//Department department=new Department();
			//department.setId(1);
			//issue.setDEPARTMENT_ID(department);
			System.out.println(issueDao.findStatus(userinfo.getId(), issueid));
//			issue.setSUBJECT("LOGIN FAULT");
//			issue.setDESCRIPTION("TOUCH DOESNT WORK");
			
			//issue.setPRIORITY("MEDIUM");
			//issueDao.updateDescription(issue);
		//	issueDao.save(issue);
//			List<Issue> list = issueDao.findAll();
//			Iterator<Issue> i = list.iterator();
//			while (i.hasNext()) {
//				Issue issues = (Issue) i.next();
//System.out.println(issue.getId()+"\t"+issue.getUSER_ID().getId()+"\t"+issue.getDEPARTMENT_ID().getId()
						//+"\t"+issue.getSUBJECT()+"\t"+issue.getDESCRIPTION()+"\t"+issue.getCREATED_DATE()+"\t"
						//+issue.getRESOLVED_DATE()+"\t"+issue.getSTATUS());
//			}
//			System.out.println(issueDao.findStatus(2, 3).getSTATUS());
		}

	}

