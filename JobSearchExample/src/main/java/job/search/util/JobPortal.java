package job.search.util;

import job.search.dto.Company;
import job.search.dto.JobSeeker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class JobPortal {

    private final String portalName;
    private final List<Company> companyList;

    private List<JobSeeker> jobSeekerList = new ArrayList<>();

    public JobPortal(String portalName, List<Company> companyList) {
        this.portalName = portalName;
        this.companyList = companyList;
    }

    public void unRegister(JobSeeker jobSeeker) {
        boolean flag = jobSeekerList.remove(jobSeeker);
        if (flag) {
            String message = String.format("%n %s is un-registered from portal - %s %n", jobSeeker.getCandidateName(), portalName);
            System.out.printf(message);
        }
        String failureMessage = String.format("%n Invalid! %s is no such candidate registered with us %n", jobSeeker.getCandidateName());
        System.out.printf(failureMessage);

    }

    public void register(JobSeeker jobSeeker) {
        if (jobSeekerList.contains(jobSeeker)) {
            String message = String.format("%n %s is already registered with Job Portal - %s %n", jobSeeker.getCandidateName(), portalName);
            System.out.printf(message);
            return;
        }
        jobSeekerList.add(jobSeeker);
        Company company = findMatchingProfile(jobSeeker);
        if (company == null) {
            String failureMessage = String.format("%n %s is registered with Job Portal - %s %n unfortunately No matching profile %n", jobSeeker.getCandidateName(), portalName);
            System.out.printf(failureMessage);
            return;
        }
        String successMessage = String.format("%n %s is registered with Job Portal - %s %n %s will soon contact you ! %n", jobSeeker.getCandidateName(), portalName, company.getName());
        System.out.printf(successMessage);
        company.shareProfile(jobSeeker);
    }

    public void update(JobSeeker jobSeeker) {
        Company company = findMatchingProfile(jobSeeker);
        if (company == null) {
            String failureMessage = String.format("%n No matching profile found for %s %n", jobSeeker.getCandidateName());
            System.out.printf(failureMessage);
            return;
        }
        String successMessage = String.format("%n %s will soon contact %s ! %n", company.getName(), jobSeeker.getCandidateName());
        System.out.printf(successMessage);
        company.shareProfile(jobSeeker);
    }

    private Company findMatchingProfile(JobSeeker jobSeeker) {
        Predicate<Company> matchpredicate = comp ->
                (comp.getJobDescription().getRequiredSkill().equalsIgnoreCase(jobSeeker.getJobProfile().getSkillSet())) && (comp.getJobDescription().getRequiredExp() <= jobSeeker.getJobProfile().getYearsOfExp());
        Optional<Company> optCompany = companyList.stream().filter(matchpredicate).findAny();
        if (!optCompany.isPresent()) {
            return null;
        }
        return optCompany.get();
    }
}
