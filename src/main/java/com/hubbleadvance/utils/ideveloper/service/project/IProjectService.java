package com.hubbleadvance.utils.ideveloper.service.project;

import java.util.List;

import com.hubbleadvance.utils.ideveloper.domain.project.Project;

public interface IProjectService {
    List<Project> listById(String id);
}
