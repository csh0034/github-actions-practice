# GitHub Actions Practice

## Github Actions 란?

- GitHub 에서 제공하는 워크플로우(workflow)를 자동화하도록 도와주는 도구이다. 
- 테스트, 빌드, 배포 등의 다양한 작업들을 자동화하여 처리한다.

### [Workflow syntax for GitHub Actions](https://docs.github.com/en/actions/using-workflows/workflow-syntax-for-github-actions)

#### `jobs.<job_id>.if`

if 문을 표현식으로 자동 처리하기 때문에 표현식 구문(`${{ }}`)을 생략할 수 있다.

```yaml
# normal
if: ${{ github.event_name == 'issues' }}

# good
if: github.event_name == 'issues'
```

### [Automatic token authentication](https://docs.github.com/en/actions/security-guides/automatic-token-authentication)

workflow 스크립트 작성시에 `${{secrets.GITHUB_TOKEN}}` 와 같은 토큰을 사용하는데   
이는 workflow 실행시에 GitHub 가 자동으로 유니크한 토큰을 세팅을 해주므로 따로 설정하지 않아도 된다. 

## 다양한 Actions

### [Gradle Build Action](https://github.com/marketplace/actions/gradle-build-action)

- GitHub Actions 가 지원하는 platform 에서 Gradle 빌드를 실행할수 있도록 지원한다.
- workflow 에서 gradle 을 직접 호출할수 있으며 Gradle 종속성 캐싱을 지원한다.

### [GitHub Script](https://github.com/marketplace/actions/github-script)

- GitHub API 및 workflow run context 를 이용하여 workflow 에서 스크립트를 쉽고 빠르게 작성할 수 있도록 지원한다.

### [Cache](https://github.com/marketplace/actions/cache)

- 종속성을 캐싱하고 출력을 빌드하여 워크플로 실행 시간을 개선할 수 있도록 한다.
- 다양한 언어와 프레임워크에는 고유한 캐싱방법이 존재하는데 이에 따라 다양한 처리 방법을 지원한다. 
  - [Examples](https://github.com/actions/cache/blob/main/examples.md)
- [caching-dependencies-to-speed-up-workflows](https://docs.github.com/en/actions/using-workflows/caching-dependencies-to-speed-up-workflows)

> Gradle Build Action 을 사용할 경우 캐싱기능이 포함되어있기 때문에 같이 사용하지 않아도 될것같다.

### [Configure AWS Credentials](https://github.com/marketplace/actions/configure-aws-credentials-action-for-github-actions)

- 다른 GitHub job 에서 사용할 AWS 자격 증명 및 region 환경 변수를 구성한다.
- 환경변수는 aws sdk, aws cli 에서 모두 감지된다.
- 자격 증명을 위해 Amazon IAM Best Practice 를 따르는것이 좋으며 단기 자격증명을 위해 GitHub OIDC 를 사용하는것이 좋다.
  - [Amazon Web Services 에서 OpenID Connect 구성](https://docs.github.com/ko/actions/deployment/security-hardening-your-deployments/configuring-openid-connect-in-amazon-web-services)

## 참조
- [GitHub Actions 배포 자동화하기](https://meetup.toast.com/posts/286)
