package com.likesea.mgr.service.system;

import com.likesea.bean.RespEntity;
import com.likesea.mgr.service.ServiceProxyBase;
import com.likesea.system.domain.AuthorityResource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class AuthorService extends ServiceProxyBase {

    public List<AuthorityResource> queryMenuList(Map mParams) {
        ResponseEntity<List<AuthorityResource>> result = restTemplate.exchange("http://system-data/admin/queryMenuList",
                HttpMethod.POST, new HttpEntity(mParams),
                new ParameterizedTypeReference<List<AuthorityResource>>() {
                });
        return result.getBody();
    }

    public AuthorityResource getMenuByMId(int mid) {
        ResponseEntity<AuthorityResource> resEntity = restTemplate.getForEntity("http://system-data/admin/getMenuByMId/{mid}", AuthorityResource.class, mid);

        return resEntity.getBody();
    }

    public List<AuthorityResource> getMenuByUId(int uid) {
        ResponseEntity<AuthorityResource[]> resEntity = restTemplate.getForEntity("http://system-data/admin/getMenuByUId/{uid}", AuthorityResource[].class, uid);

        return Arrays.asList(resEntity.getBody());
    }

    public List queryPermissionList(Map mParams) {
        ResponseEntity<List<AuthorityResource>> result = restTemplate.exchange("http://system-data/admin/queryPermissionList",
                HttpMethod.POST, new HttpEntity(mParams),
                new ParameterizedTypeReference<List<AuthorityResource>>() {
                });
        return result.getBody();
    }

    public RespEntity saveMenu(AuthorityResource authRes) {
        ResponseEntity<RespEntity> resEntity = restTemplate.postForEntity("http://system-data/admin/saveMenu",
                authRes, RespEntity.class);
        return resEntity.getBody();
    }

    public List queryAuthResByRId(int roleId, int type) {
        ResponseEntity<List<AuthorityResource>> result = restTemplate.exchange("http://system-data/admin/queryAuthResByRId?roleId={roleId}&type={type}",
                HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<AuthorityResource>>() {
                },
                roleId, type);

        return result.getBody();
    }
}
