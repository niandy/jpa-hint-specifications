В приложении надо добавить такую аннотацию, чтобы репозитории создавались с нужным классом

````
@EnableJpaRepositories(
basePackages = {"your.package"},
repositoryBaseClass = HintAwareRepository.class)
````

Для использования проекций надо вызвать метод
````
<S extends T, R> R findBy(Specification<T> spec, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
````

Например
````
UserRepository repo;
Specification<User> spec;
List<UserProjection> result = repo.findBy(spec, q -> q.as(UserProjection.class).all());
````