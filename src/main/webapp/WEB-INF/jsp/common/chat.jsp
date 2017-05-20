<%--
  Created by IntelliJ IDEA.
  User: xjy
  Date: 2017/5/20
  Time: 上午9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="panel panel-default chat">
    <div class="panel-heading" id="accordion">
        <svg class="glyph stroked two-messages">
            <use xlink:href="#stroked-two-messages"></use>
        </svg>
        Chat
    </div>
    <div class="panel-body">
        <ul>
            <li class="left clearfix">
								<span class="chat-img pull-left">
									<img src="http://placehold.it/80/30a5ff/fff" alt="User Avatar" class="img-circle"/>
								</span>
                <div class="chat-body clearfix">
                    <div class="header">
                        <strong class="primary-font">John Doe</strong>
                        <small class="text-muted">32 mins ago</small>
                    </div>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ante turpis, rutrum
                        ut ullamcorper sed, dapibus ac nunc. Vivamus luctus convallis mauris, eu gravida
                        tortor aliquam ultricies.
                    </p>
                </div>
            </li>
            <li class="right clearfix">
								<span class="chat-img pull-right">
									<img src="http://placehold.it/80/dde0e6/5f6468" alt="User Avatar"
                                         class="img-circle"/>
								</span>
                <div class="chat-body clearfix">
                    <div class="header">
                        <strong class="pull-left primary-font">Jane Doe</strong>
                        <small class="text-muted">6 mins ago</small>
                    </div>
                    <p>
                        Mauris dignissim porta enim, sed commodo sem blandit non. Ut scelerisque sapien eu
                        mauris faucibus ultrices. Nulla ac odio nisl. Proin est metus, interdum scelerisque
                        quam eu, eleifend pretium nunc. Suspendisse finibus auctor lectus, eu interdum
                        sapien.
                    </p>
                </div>
            </li>
            <li class="left clearfix">
								<span class="chat-img pull-left">
									<img src="http://placehold.it/80/30a5ff/fff" alt="User Avatar" class="img-circle"/>
								</span>
                <div class="chat-body clearfix">
                    <div class="header">
                        <strong class="primary-font">John Doe</strong>
                        <small class="text-muted">32 mins ago</small>
                    </div>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ante turpis, rutrum
                        ut ullamcorper sed, dapibus ac nunc. Vivamus luctus convallis mauris, eu gravida
                        tortor aliquam ultricies.
                    </p>
                </div>
            </li>
        </ul>
    </div>

    <div class="panel-footer">
        <div class="input-group">
            <input id="btn-input" type="text" class="form-control input-md"
                   placeholder="Type your message here..."/>
            <span class="input-group-btn">
								<button class="btn btn-success btn-md" id="btn-chat">Send</button>
							</span>
        </div>
    </div>
</div>
