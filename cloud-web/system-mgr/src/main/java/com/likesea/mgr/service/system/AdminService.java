package com.likesea.mgr.service.system;

import com.github.pagehelper.PageInfo;
import com.likesea.bean.RespEntity;
import com.likesea.mgr.service.ServiceProxyBase;
import com.likesea.system.domain.AuthorityApp;
import com.likesea.system.domain.AuthorityMember;
import com.likesea.system.domain.AuthorityRole;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminService extends ServiceProxyBase {

    public AuthorityMember loginByMemberName(String username, String password){
        ResponseEntity<AuthorityMember> resEntity = restTemplate.getForEntity("http://system-data/admin/loginByMemberName?username={username}&password={password}",
                AuthorityMember.class, username, password);

        return resEntity.getBody();
    }

    public PageInfo queryMemberList(Map mParams, int pageNo, int pageSize) {
        ResponseEntity<PageInfo> resEntity = restTemplate.postForEntity("http://system-data/admin/queryMemberList?pageNo={pageNo}&pageSize={pageSize}",
                mParams, PageInfo.class, pageNo, pageSize);
        if ("200".equals(resEntity.getStatusCode())) {

        }
        return resEntity.getBody();
    }

    public AuthorityMember getMemberById(long uid) {
        return restTemplate.getForObject("http://system-data/admin/getMemberById/{uid}", AuthorityMember.class, uid);
    }

    public RespEntity saveAuthMember(AuthorityMember authMember) {
        ResponseEntity<RespEntity> resEntity = restTemplate.postForEntity("http://system-data/admin/saveAuthMember",
                authMember, RespEntity.class);
        return resEntity.getBody();
    }

    public List<AuthorityRole> queryRoleList(Map mParams) {
        HttpEntity httpEntity = new HttpEntity(mParams);
        ResponseEntity<List<AuthorityRole>> result = restTemplate.exchange("http://system-data/admin/queryRoleList",
                HttpMethod.POST, httpEntity,
                new ParameterizedTypeReference<List<AuthorityRole>>() {
                });
        return result.getBody();
    }

    public AuthorityRole getRoleById(int rid) {
        return restTemplate.getForObject("http://system-data/admin/getRoleById/{rid}", AuthorityRole.class, rid);
    }

    public RespEntity saveAuthRole(AuthorityRole authRole) {
        ResponseEntity<RespEntity> resEntity = restTemplate.postForEntity("http://system-data/admin/saveAuthRole",
                authRole, RespEntity.class);
        return resEntity.getBody();
    }

    public List<AuthorityApp> queryAppList(Map mParams) {
        HttpEntity httpEntity = new HttpEntity(mParams);
        ResponseEntity<List<AuthorityApp>> result = restTemplate.exchange("http://system-data/admin/queryAppList",
                HttpMethod.POST, httpEntity,
                new ParameterizedTypeReference<List<AuthorityApp>>() {
                });
        return result.getBody();
    }

    public AuthorityApp getAppById(int aid) {
        return restTemplate.getForObject("http://system-data/admin/getAppById/{rid}", AuthorityApp.class, aid);
    }

    public RespEntity saveApp(AuthorityApp authApp) {
        ResponseEntity<RespEntity> resEntity = restTemplate.postForEntity("http://system-data/admin/saveApp",
                authApp, RespEntity.class);
        return resEntity.getBody();
    }

    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }
}
