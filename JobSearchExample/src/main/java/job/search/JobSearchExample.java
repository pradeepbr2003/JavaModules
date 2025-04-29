package job.search;

import job.search.common.*;
import job.search.dto.Company;
import job.search.dto.JobDescription;
import job.search.dto.JobProfile;
import job.search.dto.JobSeeker;
import job.search.util.JobPortal;

import java.util.List;
import java.util.Random;
import java.util.UUID;


public class JobSearchExample {
    public static void main(String[] args) {
        Random random = new Random();
        for (; ; ) {
            double yearsOfExp = random.nextDouble(2, 15);

            SKillEnum[] skillSet = SKillEnum.values();
            DesignationEnum[] designation = DesignationEnum.values();
            CompanyEnum[] comp = CompanyEnum.values();
            LocationEnum[] location = LocationEnum.values();
            PortalEnum[] portal = PortalEnum.values();
            JobSeekerNameEnum[] empName = JobSeekerNameEnum.values();

            JobProfile jobProfile = JobProfile.builder()
                    .yearsOfExp(yearsOfExp)
                    .currentRole(designation[random.nextInt(designation.length)].name())
                    .skillSet(skillSet[random.nextInt(skillSet.length)].name())
                    .build();

            String uuid = UUID.randomUUID().toString();
            String name = empName[random.nextInt(empName.length)].name();
            String email = name + "@gmail.com";

            JobSeeker jobSeeker = JobSeeker.builder()
                    .jobProfile(jobProfile)
                    .candidateName(name).candidateEmail(email).panNumber(uuid).currentCompany(comp[random.nextInt(comp.length)].name())
                    .build();

            JobDescription jd = JobDescription.builder()
                    .requiredExp(yearsOfExp)
                    .requiredSkill(skillSet[random.nextInt(skillSet.length)].name())
                    .designation(designation[random.nextInt(designation.length)].name())
                    .build();

            Company company = Company.builder()
                    .jobDescription(jd)
                    .location(location[random.nextInt(location.length)].name())
                    .name(comp[random.nextInt(comp.length)].name())
                    .build();

            JobPortal jobPortal = new JobPortal(portal[random.nextInt(portal.length)].name(), List.of(company));
            jobPortal.register(jobSeeker);

            jobPortal.unRegister(jobSeeker);

        }
    }
}